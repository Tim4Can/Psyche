<template>
  <page-view title="我的预约">
    <a-card>
      <template>
        <a-table :columns="columns" :dataSource="rDataShow" rowKey="id" bordered>
          <template
              v-for="col in ['id', 'teacherName', 'reserveTime', 'address']"
              :slot="col"
              slot-scope="text"
            >
            <div :key="col">{{ text }}</div>
          </template>
          <template slot="operation" slot-scope="text, record">
            <a-button
              size="small"
              type="danger"
              :hidden='text'
              @click="onClickDelete(record.id)"
            >取消预约
            </a-button>
            <a-modal
              title="确认取消"
              v-model="visible2"
              @ok="onClickDeleteRow"
            >
              <div class="modal">
                是否取消本次预约
              </div>
            </a-modal>
          </template>
        </a-table>
        <template>
          <a-pagination @change="onChange" :current="current" :total="totalPage" />
        </template>
      </template>
    </a-card>
  </page-view>
</template>


<script>
import Fuse from 'fuse.js'
import Vue from 'vue'
import { getMyReserve, cancelAppointment } from '@/api/counseling'
import Lightbox from 'vue-easy-lightbox'
import { PageView } from '@/layouts'
Vue.use(Lightbox)

const columns = [
  {
    title: '预约单号',
    dataIndex: 'id',
    //width: '10%',
    align: 'center',
    scopedSlots: { customRender: 'id' },
    sorter: (a, b) => a.id > b.id,
  },
  {
    title: '老师姓名',
    dataIndex: 'teacherName',
   //width: '15%',
    align: 'center',
    scopedSlots: { customRender: 'teacherName' },
  },
  {
    title: '预约时间',
    dataIndex: 'reserveTime',
    align: 'center',
    width: '18%',
    scopedSlots: { customRender: 'reserveTime' },
    sorter: (a, b) => a.reserveTime > b.reserveTime
  },
  {
    title: '预约地址',
    dataIndex: 'address',
    align: 'center',
    width: '30%',
    scopedSlots: { customRender: 'address' }
  },
  {
    titile: '操作',
    align: 'center',
    dataIndex: 'operation',
    scopedSlots: { customRender: 'operation' }
  },
]

const rData=[]
const rDataShow=[]

export default {
  name: 'myReservation',
  inject: ['reload'],
  components: {
    PageView
  },
  data() {
     return {
        rData,
        rDataShow,
        deleteInfo:'',
        columns,
        current: 1,
        totalPage:'',
        visible2: false,
        todelete:'',
        form: this.$form.createForm(this)
     };
  },
  filters: {
    statusFilter (type) {
       return statusMap[type].text
    },
    statusTypeFilter (type) {
       return statusMap[type].status
    }
  },
  methods:{
    onClickDeleteRow () {
      this.visible2 = false;
      const newData = [...this.rDataShow]
      console.log(newData)
      const target = newData.filter(item => this.todelete === item.id)[0]
      console.log(target)

      cancelAppointment({ id : target.id}).then((response) => {
        this.deleteInfo = response.info
        if(this.deleteInfo !== 'fail'){
          this.rData = [...response.data]
          this.rDataShow = this.rData
        }
        if(this.deleteInfo === 'ok'){
          this.$notification.open({
          message: '取消成功',
          description: '本条预约取消成功',
          icon: <a-icon type="check" style="color: #108ee9" />,
        });
        }
        else{
          this.$notification.open({
          message: '取消失败',
          description: '本条预约取消失败',
          icon: <a-icon type="warning" style="color: #108ee9" />,
        });
        }
      })
      // to be complete
      },
      onClickRefresh(){
        this.reload()
      },
      onClickDelete (id) {
        console.log(id)
        this.todelete = id
        this.visible2 = true;
      },
      onChange(current){
        this.current=current;
        getMyReserve(this.current).then((response)=>{
        console.log(response);
        console.log(this.page);
        this.rData=response.data;
        this.rDataShow=this.rData.reserve;
        this.totalPage=this.rData.totalPage
      })
     }
    },
    mountend(){
      getMyReserve(this.current).then((response)=>{
        console.log(response);
        console.log(this.page);
        this.rData=response.data;
        this.rDataShow=this.rData.reserve;
        this.totalPage=this.rData.totalPage
      })
    }
  };

</script>

<style lang="less" scoped>
@import '~ant-design-vue/lib/style/themes/default.less';
.button-group {
  margin-bottom: 1rem;
  .button {
    margin-left: 0.5rem;
    margin-left: 0.5rem;
  }
}
</style>
