<template>
  <page-view title="老师信息">
    <a-card>
     <detail-list size="small" :col="1" class="detail-layout">
        <detail-list-item term="老师姓名">{{name}}</detail-list-item>
        <detail-list-item term="详细描述">{{introduction}}</detail-list-item>
        <detail-list-item term="咨询地址">{{address}}</detail-list-item>
      </detail-list>
    </a-card>
    <a-card style="margin-top:20px">
         <a-row :gutter="16">
            <a-col :span="8"><h2>选择预约时间</h2></a-col>
            <a-col :span="8">
              <a-button
                style="margin-right : 1rem"
                @click="reserve()"
                type="primary"
              >确定预约
              </a-button>
            </a-col>
         </a-row>
         <a-row :gutter="16">
              <a-card>
                <a-col :span="5">
                  </br>
                  <a-row>
                    <p>10:00~11:00</P>
                  </a-row>
                  <a-row>
                    <p>11:00~12:00</P>
                  </a-row>
                  <a-row>
                    <p>14:00~15:00</P>
                  </a-row>
                  <a-row>
                    <p>15:00~16:00</P>
                  </a-row>
                </a-col>
                <a-col>
                <a-row>
                <a-col :span="2">
                  <h4>周一</h4>
                  <a-button-group @click="setMonday()">
                  <a-row>
                    <a-button @click="setOne()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setTwo()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setThree()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setFour()" />
                  </a-row>
                  </a-button-group>
                </a-col>
                <a-col :span="2">
                  <h4>周二</h4>
                  <a-button-group @click="setTuesday()">
                  <a-row>
                    <a-button  @click="setOne()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setTwo()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setThree()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setFour()" />
                  </a-row>
                  </a-button-group>
                </a-col>
                <a-col :span="2">
                  <h4>周三</h4>
                  <a-button-group @click="setWednesday()">
                  <a-row>
                    <a-button  @click="setOne()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setTwo()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setThree()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setFour()" />
                  </a-row>
                  </a-button-group>
                </a-col>
                <a-col :span="2">
                  <h4>周四</h4>
                  <a-button-group @click="setThursday()">
                  <a-row>
                    <a-button  @click="setOne()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setTwo()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setThree()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setFour()" />
                  </a-row>
                  </a-button-group>
                </a-col>
                <a-col :span="2">
                  <h4>周五</h4>
                  <a-button-group @click="setFriday()">
                  <a-row>
                    <a-button @click="setOne()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setTwo()"/>
                  </a-row>
                  <a-row>
                    <a-button @click="setThree()" />
                  </a-row>
                  <a-row>
                    <a-button @click="setFour()" />
                  </a-row>
                  </a-button-group>
                </a-col>
                </a-row>
                </a-col>
              </a-card>
         </a-row>
    </a-card>
  </page-view>

</template>

<script>
import { mixinDevice } from '@/utils/mixin'
import { PageView } from '@/layouts'
import DetailList from '@/components/tools/DetailList'
import {postTeacherDetail} from '@/api/teacher'
import {chooseTime} from '@/api/counseling'
import ACol from "ant-design-vue/es/grid/Col";
import {mapGetters} from 'vuex'

const DetailListItem = DetailList.Item

export default {
  inject: ['reload'],
  created(){

  },
  name: 'teacherDetail',
  components: {
     ACol,
     PageView,
     DetailList,
     DetailListItem
  },
  data () {
    return {
      teacherID: this.$route.params.id,
      DetailData:'',
      TimeData:'',
      name:'',
      introduction:'',
      address:'',
      day:'',
      period:'',
      time:{
        'day' : '',
        'period':'',
      },
      chooseInfo:'',
    }
  },
  methods: {
     setMonday(){
       this.day=1;
     },
     setTuesday(){
       this.day=2;
     },
     setWednesday(){
       this.day=3;
     },
     setThursday(){
       this.day=4;
     },
     setFriday(){
       this.day=5;
     },
     setOne(){
       this.period=1;
     },
     setTwo(){
       this.period=2;
     },
     setThree(){
       this.period=3;
     },
     setFour(){
       this.period=4;
     },
     reserve(){
        chooseTime(this.time).then((response)=>{
          this.chooseInfo=response.info
          if(this.addInfo === 'ok'){
          this.$notification.open({
          message: '预约成功',
          description: '预约成功',
          icon: <a-icon type="check" style="color: #108ee9" />,
        });
          this.Data = [...response.data]
          this.DataShow = this.Data
        }
        else{
          this.$notification.open({
          message: '预约失败',
          description: '预约失败',
          icon: <a-icon type="warning" style="color: #108ee9" />,
        });
        }
       })
     }
  },
  mounted(){
    postTeacherDetail(this.teacherID).then((response)=>{
      console.log(response.data);
      //console.log(this.teacherID);
      this.DetailData = response.data;
      this.name=this.DetailData.name;
      this.introduction=this.DetailData.introduction;
      this.address=this.DetailData.address;
    })

  }
}

</script>

<style lang="less" scoped>

  .detail-layout {
    margin-left: 44px;
  }
  .text {
    color: rgba(0, 0, 0, .45);
  }

  .heading {
    color: rgba(0, 0, 0, .85);
    font-size: 20px;
  }

  .no-data {
    color: rgba(0, 0, 0, .25);
    text-align: center;
    line-height: 64px;
    font-size: 16px;

    i {
      font-size: 24px;
      margin-right: 16px;
      position: relative;
      top: 3px;
    }
  }

  .photo {
      align: center;
  }

  .mobile {
    .detail-layout {
      margin-left: unset;
    }
    .text {

    }
    .status-list {
      text-align: left;
    }
  }
</style>