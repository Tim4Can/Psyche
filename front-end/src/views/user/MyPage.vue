<template>
  <page-view title="个人中心">
    <a-row>
      <a-col :md="24" :lg="7">
        <a-card style="width:300px">
        <a-table :columns="columns" :dataSource="data" :pagination="false">
          <span slot="customTitle"><a-avatar src="userInfo.headPortrait" /> 学号</span>
        </a-table>
        <br/>
        <div>
            <a-button type="primary" @click="showModal">修改密码</a-button>
            <a-modal
              title="修改密码"
              :visible="visible"
              :confirmLoading="confirmLoading"
            >
                <a-form title="修改密码" @submit="handleSubmit" :form="form">
                  <a-form-item
                    :wrapperCol="{ span: 24 }"
                    style="text-align: center"
                  >
                  </a-form-item>
                  <a-form-item
                    label="旧密码"
                    :labelCol="{lg: {span: 7}, sm: {span: 7}}"
                    :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
                    <a-input
                      type="password"
                      v-decorator="[
            'old_password',
            {rules: [{ required: true, message: '请输入旧的密码' }]}
          ]"
                      name="old_password"
                      placeholder="请输入旧的密码"/>
                  </a-form-item>
                  <a-form-item
                    label="新密码"
                    :labelCol="{lg: {span: 7}, sm: {span: 7}}"
                    :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
                    <a-input
                      type="password"
                      v-decorator="[
            'new_password',
            {rules: [{ required: true, message: '请输入新的密码' }]}
          ]"
                      name="new_password"
                      placeholder="请输入新的密码"/>
                  </a-form-item>
                   <a-form-item
                    label="新密码"
                    :labelCol="{lg: {span: 7}, sm: {span: 7}}"
                    :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
                    <a-input
                      type="password"
                      v-decorator="[
            'new_password',
            {rules: [{ required: true, message: '请输入新的密码' }]}
          ]"
                      name="new_password"
                      placeholder="请再次输入新的密码"/>
                  </a-form-item>
                  <a-form-item
                    :wrapperCol="{ span: 24 }"
                    style="text-align: center"
                  >
                    <a-button htmlType="submit" type="primary">提交</a-button>
                    <a-button style="margin-left: 8px" @click="handleCancel">取消</a-button>
                  </a-form-item>
                </a-form>
            </a-modal>
          </div>
        </a-card>
      </a-col>
      <a-col>
        <a-card
          style="width:100%"
          :tabList="tabListNoTitle"
          :activeTabKey="noTitleKey"
          @tabChange="key => onTabChange(key, 'noTitleKey')"
        >
        <template v-if="noTitleKey === '发帖'">
          <a-list :dataSource="postData">
          <a-list-item>
            <a-card :bordered="false" style="width:100%">
             <a slot="actions" @click="onClickDelete(record.id)">删除</a>
             <a-modal
                title="确认删除"
                v-model="visible3"
                @ok="onClickDeleteRow"
             >
             <div class="modal">
                是否删除本条帖子
             </div></a-modal>
              <a-card-meta title='item.title'>
                <template slot="description">
                  <ellipsis :length="70">{{ item.content }}</ellipsis>
                </template>
                <template slot="description">
                  <ellipsis :length="70">{{ item.sendTime }}</ellipsis>
                </template>
                <template slot="toDetail" slot-scope="text, record">
                <div>
                  <router-link :to="{ name: 'PostDetail', params:{ id: getID(record.id)} }">帖子详情</router-link>
                </div>
                </template>
              </a-card-meta>
            </a-card>
          </a-list-item>
        </a-list>
        <!-- <div id="pagination" >
          <a-pagination @change="onChange1" :current="current" :total="totalPage1" />
        </div> -->
        </template>
      <template v-else="noTitleKey === '收藏'">
        <a-list :dataSource="likeData" :pagination="pagination">
          <a-list-item>
            <a-card :bordered="false" style="width:100%">
              <a-card-meta title='item.title'>
                <template slot="description">
                  <ellipsis :length="70">{{ item.content }}</ellipsis>
                </template>
                <template slot="description">
                  <ellipsis :length="70">{{ item.sendTime }}</ellipsis>
                </template>
                <img style="width:100px"
                  slot="avatar"
                  src="item.img" //收藏的文章的图片
                />
              </a-card-meta>
            </a-card>
          </a-list-item>
        </a-list>
        <!-- <div id="pagination" >
          <a-pagination @change="onChange2" :current="current" :total="totalPage2" />
        </div> -->
      </template>
       </a-card>
       </a-card>
      </a-col>
    </a-row>
  </page-view>
</template>

<script>
import {timeFix} from '@/utils/util'
import {mapGetters} from 'vuex'
import {Button} from 'ant-design-vue'
import {PageView} from '@/layouts'
import {Radar} from '@/components'
import {getInfo} from '@/api/user'
import {modifyPwd, getMyPost, getMyLike} from '@/api/userInfo'
import {deleteTreehole} from '@/api/Treehole'
import ARow from "ant-design-vue/es/grid/Row";
import ACol from "ant-design-vue/es/grid/Col";
import AFormItem from "ant-design-vue/es/form/FormItem";
import md5 from 'md5'

const columns = [
    {
      dataIndex: 'number',
      key: 'number',
    },
    {
      title: '姓名',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '昵称',
      dataIndex: 'nickname',
      key: 'nickname',
    },
  ];
const data = [
    {
      number: "userInfo.number",
      name: "userInfo.name",
      nickname: "userInfo.nickname",
    },
 ]
export default {
    name: 'TableList',
    inject: ['reload'],
    components: {
        AFormItem,
        ACol,
        ARow,
        PageView,
        Radar,
        STable,
      },
    data() {
      return {
        postData: [],
        likeData: [],
        allPostData: [],
        allLikeData: [],
        totalPage1: '',
        totalPage2: '',
        current1: 1,
        current2: 1,
        data,
        columns,
        user: {},
        loading: true,
        radarLoading: true,
        old_password: '',
        new_password: '',
        form: this.$form.createForm(this),
        visible: false,
        todelete:'',
        new_identity: {
          id: '',
          newPassword: '',
        },
        confirmLoading: false,

        tabList: [
          {
            key: 'tab1',
            // tab: 'tab1',
            scopedSlots: { tab: 'customRender' },
          },
          {
            key: 'tab2',
            tab: 'tab2',
          },
        ],
        contentList: {
          tab1: 'content1',
          tab2: 'content2',
        },
        tabListNoTitle: [
          {
            key: '发帖',
            tab: '发帖',
          },
          {
            key: '收藏',
            tab: '收藏',
          },
        ],
        key: 'tab1',
        noTitleKey: '发帖',
      };
    },
    computed: {
      userInfo() {
        return this.$store.getters.userInfo
      }
    },
    methods: {
      onTabChange(key, type) {
        console.log(key, type);
        this[type] = key;
      },
      showModal() {
        this.visible = true;
      },
      handleSubmit(e) {
        this.confirmLoading = true;
        setTimeout(() => {
          this.visible = false;
          this.confirmLoading = false;
        }, 2000);
      },
      handleCancel(e) {
        console.log('Clicked cancel button');
        this.visible = false;
      },
      handleSubmit(e) {
        e.preventDefault()
        this.form.validateFields((err, value) => {
          if (!err) {
            if (md5(value.old_password) === this.userInfo.password) {
              this.new_identity.newPassword = md5(value.new_password)
              this.new_identity.id = this.userInfo.id
              console.log(this.new_identity)
              modifyPwd(this.new_identity).then(() => {
                this.$message.success('密码修改成功！')
              })
              console.log("Pass!")
            } else {
              this.$message.error('旧密码输入错误！')
              console.log("Failed!")
            }
          }
        })
        this.showPasswordForm = false;
      },
      onChange1(current){
        this.current1=current;
        getMyPost(this.current1).then((response)=>{
        console.log(response);
        console.log(this.page);
        this.allPostData=response.data;
        this.postData=this.allPostData.postData;
        this.totalPage1=this.allPostData.totalPage

      })
     },
      onChange2(current){
        this.current2=current;
        getMyLike(this.current2).then((response)=>{
        console.log(response);
        console.log(this.page);
        this.allLikeData=response.data;
        this.likeData=this.allLikeData.likeData;
        this.totalPage2=this.allLikeData.totalPage //总页数
      })
     },
      onClickDelete (id) {
        console.log(id)
        this.todelete = id
        this.visible3 = true;
      },
      //delete row
      onClickDeleteRow () {
        this.visible3 = false
        const newData = [...this.postData]
        console.log(newData)
        const target = newData.filter(item => this.todelete === item.id)[0]
        console.log(target)
        deleteTreehole({id:target.id}).then((response) => {
        this.deleteInfo = response.info
        if(this.deleteInfo === 'ok'){
          this.sfData = [...response.data]
          this.sfDataShow = this.sfData
          this.$notification.open({
          message: '删除成功',
          description: '本条发帖信息删除成功',
          icon: <a-icon type="check" style="color: #108ee9" />,
        });
        }
        else{
          this.$notification.open({
          message: '删除失败',
          description: '本条发帖信息删除失败',
          icon: <a-icon type="warning" style="color: #108ee9" />,
        });
        }
      })
      },
    },
    mounted() {
      console.log('vuex', this.userInfo)

      getInfo({id: this.userID}).then((response)=>{
        console.log(...response.data)
        this.userData = [...response.data]
        this.userDataShow = this.userData
      })

      getMyPost(this.current1).then((response)=>{
        console.log(response);
        console.log(this.page);
        this.allPostData=response.data;
        this.postData=this.allPostData.postData;
        this.totalPage1=this.allPostData.totalPage

      })
      getMyLike(this.current2).then((response)=>{
        console.log(response);
        console.log(this.page);
        this.allLikeData=response.data;
        this.likeData=this.allLikeData.likeData;
        this.totalPage2=this.allLikeData.totalPage //总页数
      })
    }
}

</script>

<style lang="less" scoped>
.addButton{
    position: absolute;
    z-index: 999;
    right:1em;
    top:0em;
  }
</style>