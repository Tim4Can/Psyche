<template>
  <page-view :avatar="avatar" :title="帖子">
        <div id="layout">
              <a-button
                style="margin-right : 1rem"
                @click="handleAdd()"
                type="primary"
                icon="plus"
              >发帖
              </a-button>
        </div>

      <a-card style="top:10px">
      <a-list itemLayout="horizontal" :dataSource="Data">
          <a-list-item slot="renderItem" slot-scope="item, index">
              <a-list-item-meta :title='item.title'>
                <a-avatar
                  width="72"
                  slot="avatar"
                  :src="item.headPortrait"
                />
                <div slot="description">
                  <ellipsis :length="70">{{ item.content }}</ellipsis>
                </div>
                </br>
                <div slot="description">
                  <ellipsis :length="70">{{ item.sendTime }}</ellipsis>
                </div>

              </a-list-item-meta>
              <div>
                 <router-link :to="{ name: 'postDetail', params:{ id: item.id} }">帖子详情</router-link>
              </div>
          </a-list-item>
      </a-list>
      <div style="margin-top:20px">
        <a-pagination @change="onChange" :current="current" :total="totalPage" />
      </div>
    </a-card>
    <a-modal
              title="发帖"
              :visible="visible"
              @ok="handleTreeholeOk"
              :confirmLoading="confirmLoading"
              @cancel="handleCancel"
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
              <a-form-item
                :labelCol="labelCol"
                :wrapperCol="wrapperCol"
                label="是否匿名"
                hasFeedback
              >
                <template>
                    <a-radio-group name="radioGroup" :defaultValue="1">
                        <a-radio :value="1">匿名</a-radio>
                        <a-radio :value="2">不匿名</a-radio>
                    </a-radio-group>
                </template>
              </a-form-item>
            </a-form>
    </a-modal>
    <a-modal
          title="确认发布"
          :visible="visible5"
          @ok="onClickNewRow"
          @cancel="onClickCancel"
        >
          <div class="modal">
            是否确认发布
          </div>
    </a-modal>
  </page-view>
</template>

<script>
import moment from 'moment'
import { TagSelect, StandardFormRow, Ellipsis, AvatarList } from '@/components'
import Fuse from 'fuse.js'
import { getPost, sendTreehole} from '@/api/Treehole'
  import {timeFix} from '@/utils/util'
  import {mapGetters} from 'vuex'
  import {Button} from 'ant-design-vue'
  import {PageView} from '@/layouts'
  import HeadInfo from '@/components/tools/HeadInfo'
  import {Radar} from '@/components'
  import ARow from "ant-design-vue/es/grid/Row";
  import ACol from "ant-design-vue/es/grid/Col";
  import AFormItem from "ant-design-vue/es/form/FormItem";

  const DataSet = require('@antv/data-set')

  export default {
    name: 'post',
    components: {
      AFormItem,
      ACol,
      ARow,
      PageView,
      HeadInfo,
      Radar
    },
    data() {
      return {
        Data:[],
        allData:[],
        current: 1,
        totalPage: '',
        visible: false,
        visible5: false,
        addmdl:{
          'title':'',
          'content':'',
          'incognito': '',
        },
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
       handleAdd () {
          this.visible = true
       },
       handleCancel(){
          this.visible=false
       },
       onClickCancel(){
          this.visible5=false
       },
     handleTreeholeOk(){
      this.visible=false
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
        this.visible = false
        this.visible5 = false
        this.addmdl.incognito=this.value
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
    },
    mounted() {
      getPost(this.current).then((response)=>{
        this.allData=response.data;
        this.Data=this.allData.post; //当前页的树洞信息
        this.totalPage=this.allData.totalPage //总页数
        console.log(this.totalPage);
        console.log(this.Data);
      })
    }

  }
</script>

<style lang="less" scoped>
  .project-list {

    .card-title {
      font-size: 0;

      a {
        color: rgba(0, 0, 0, 0.85);
        margin-left: 12px;
        line-height: 24px;
        height: 24px;
        display: inline-block;
        vertical-align: top;
        font-size: 14px;

        &:hover {
          color: #1890ff;
        }
      }
    }

    .card-description {
      color: rgba(0, 0, 0, 0.45);
      height: 44px;
      line-height: 22px;
      overflow: hidden;
    }

    .project-item {
      display: flex;
      margin-top: 8px;
      overflow: hidden;
      font-size: 12px;
      height: 20px;
      line-height: 20px;

      a {
        color: rgba(0, 0, 0, 0.45);
        display: inline-block;
        flex: 1 1 0;

        &:hover {
          color: #1890ff;
        }
      }

      .datetime {
        color: rgba(0, 0, 0, 0.25);
        flex: 0 0 auto;
        float: right;
      }
    }

    .ant-card-meta-description {
      color: rgba(0, 0, 0, 0.45);
      height: 44px;
      line-height: 22px;
      overflow: hidden;
    }
  }

  .item-group {
    padding: 20px 0 8px 24px;
    font-size: 0;

    a {
      color: rgba(0, 0, 0, 0.65);
      display: inline-block;
      font-size: 14px;
      margin-bottom: 13px;
      width: 25%;
    }
  }

  .members {
    a {
      display: block;
      margin: 12px 0;
      line-height: 24px;
      height: 24px;

      .member {
        font-size: 14px;
        color: rgba(0, 0, 0, .65);
        line-height: 24px;
        max-width: 100px;
        vertical-align: top;
        margin-left: 12px;
        transition: all 0.3s;
        display: inline-block;
      }

      &:hover {
        span {
          color: #1890ff;
        }
      }
    }
  }

  .mobile {

    .project-list {

      .project-card-grid {
        width: 100%;
      }
    }

    .more-info {
      border: 0;
      padding-top: 16px;
      margin: 16px 0 16px;
    }

    .headerContent .title .welcome-text {
      display: none;
    }
  }

</style>
