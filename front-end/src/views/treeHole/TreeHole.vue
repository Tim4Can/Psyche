<template>
  <page-view title="全部帖子">
    <div id="layout">
      <a-layout>
        <a-row :gutter="24">
          <a-col :span="16" style="text-align: right">
            <div style="margin-top: 2.5rem">
              <a-button
                style="margin-right : 1rem"
                @click="addTreeholeButton()"
                type="primary"
                icon="plus"
              >发帖
              </a-button>
            </div>
          </a-col>
        </a-row>
      </a-layout>
    </div>

      <!-- table -->
      <a-card title="全部">
        <a-list :dataSource="Data">
          <a-list-item>
            <a-card :bordered="false" style="width:100%">
              <a-card-meta title='item.title'>
                <template slot="description">
                  <ellipsis :length="70">{{ item.content }}</ellipsis>
                </template>
                <template slot="description">
                  <ellipsis :length="70">{{ item.sendTime }}</ellipsis>
                </template>
                <template slot="toDetail">
                <div>
                  <router-link :to="{ name: 'PostDetail', params:{ id: item.id} }">帖子详情</router-link>
                </div>
                </template>
              </a-card-meta>
            </a-card>
          </a-list-item>
        </a-list>
        <template>
          <a-pagination @change="onChange" :current="current" :total="totalPage" />
        </template>
      </a-card>
      <!-- table end -->

      <a-modal
        title="发帖"
        style="top: 20px;"
        :width="800"
        v-model="visible4"
        @ok="handleTreeholeOk"
      >
        <a-form :from="(form)=>{this.form = form} " rowKey='id' bordered>
          <a-form-item
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
            label="标题"
            :validateStatus="successAddTitle"
            hasFeedback
          >
            <a-input placeholder="请输入标题" v-model="addmdl.title" id="post_title"/>
          </a-form-item>

          <a-form-item
            :labelCol="labelCol"
            :wrapperCol="wrapperCol"
            label="内容"
            :validateStatus="successAddContent"
            hasFeedback
          >
            <a-input placeholder="请输入内容" v-model="addmdl.content" id="post_content"/>
          </a-form-item>
        </a-form>
        <a-modal
          title="确认发布"
          v-model="visible5"
          @ok="onClickNewRow"
        >
          <div class="modal">
            是否确认发布
          </div>
        </a-modal>
      </a-modal>

  </page-view>
</template>

<script>
import { getPost, sendTreehole} from '@/api/Treehole'
import Fuse from 'fuse.js'
import { PageView } from '@/layouts'
import ARow from "ant-design-vue/es/grid/Row";

  export default {
    components:{
      Ellipsis,
      TagSelect,
      TagSelectOption,
      StandardFormRow,
      PageView,
      ARow,
    },
    data() {
      return {
        Data: [],
        allData: [],
        totalPage: '',
        current: 1,
        totalPage: '',
        form: this.$form.createForm(this),
        loading: true,
        visible: false,
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 }
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 }
        },
        form: null,
        mdl: {},
        visible5:false,
        addmdl:{
          'title':'',
          'content':'',
        },
        addInfo:'',
      }
    },

    computed: {
      successAddTitle: function(){
        if(this.addmdl.title === ''){
          return "error"
        }
        return "success"
      },
      successAddContent: function(){
        if(this.addmdl.content === ''){
          return "error"
        }
        return "success"
      },
    },
    methods: {
      handleTreeholeOk(){
      if(this.successAddTitle === "error"||this.successAddContent === "error"){
        this.$notification.open({
          message: '发布失败',
          description: '请按要求填写树洞信息',
          icon: <a-icon type="exclamation-circle" style="color: #108ee9" />,
        });
        return;
      }
      this.visible5 = true
      },
      onClickRefresh(){
        this.reload()
      },
      onClickNewRow(){
      this.visible5 = false
        sendTreehole(this.addmdl).then((response) => {
        this.addInfo = response.info1
        if(this.addInfo === 'ok'){
          this.$notification.open({
          message: '发布成功',
          description: '本条树洞信息发布成功',
          icon: <a-icon type="check" style="color: #108ee9" />,
        });
          this.Data = [...response.data]
          this.DataShow = this.Data
        }
        else{
          this.$notification.open({
          message: '发布失败',
          description: '本条树洞信息发布失败',
          icon: <a-icon type="warning" style="color: #108ee9" />,
        });
        }
       })
      },
      onChange(current){
        this.current=current;
        getPost(this.current).then((response)=>{
        console.log(response);
        console.log(this.page);
        this.allData=response.data;
        this.Data=this.allData.post; //当前页的树洞信息
        this.totalPage=this.allData.totalPage //总页数
      })
      },
      clickJump(record) {
        console.log(record)
      },
    },
    mounted() {
      getPost(this.current).then((response)=>{
        console.log(response);
        console.log(this.page);
        this.allData=response.data;
        this.Data=this.allData.post; //当前页的树洞信息
        this.totalPage=this.allData.totalPage //总页数

      })
    }
  }
</script>

<style lang="less" scoped>
  @import '~ant-design-vue/lib/style/themes/default.less';

  #layout .ant-layout-header {
    background: #fff;
    color: #666;
  }

  .button-group {
    margin-bottom: 1rem;

    .button {
      margin-right: 0.5rem;
      margin-left: 0.5rem;
      margin-top: 2.7rem;
    }
  }

  .button-group2 {
    margin-top: 3em;
    margin-bottom: 1rem;
    margin-left: 39rem
  }
</style>