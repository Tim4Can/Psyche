<template>
  <page-view title="个人中心">
    <a-row>
      <a-col :md="24" :lg="7">
        <a-card style="width:300px">
        <a-table :columns="columns" :dataSource="data" :pagination="false">
          <span slot="customTitle"><a-avatar src="/avatar2.jpg" /> 学号</span>
        </a-table>
        <br/>
        <div>
            <a-button type="primary" @click="showModal">修改密码</a-button>
            <a-modal
              title="修改密码"
              :visible="visible"
              @ok="handleOk"
              :confirmLoading="confirmLoading"
              @cancel="handleCancel"
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
        <a-list :pagination="pagination">
        <a-list-item>
        <router-link :to="{ name: 'Detail' }">
        <a-card :bordered="false" style="width:100%">
          <a-card-meta title="阳光明媚的周一。" description="周一要上课了呀。">
          </a-card-meta>
          </a-card>
        </router-link>
        </a-list-item>
        <a-list-item>
        <a-card :bordered="false" style="width:100%">
          <a-card-meta title="感恩节快乐！" description="感谢这个世界，感谢你！">
          </a-card-meta>
          </a-card>
        </a-list-item>
        <a-list-item>
          <a-card :bordered="false" style="width:100%">
          <a-card-meta title="快要期末考试了" description="好好复习，好好考试，挺过这个月。">
          </a-card-meta>
          </a-card>
        </a-list-item>
        </a-list>
        </template>
      <template v-else="noTitleKey === '收藏'">
      <a-list :pagination="pagination">
      <a-list-item>
        <a-card :bordered="false" style="width:100%">
        <a-card-meta title="人际关系疗法起源与应用 | the application of IPT" description="人际关系疗法（IPT，interpersonal psychotherapy）的发现纯属偶然，类似于医药研究中的老药新用的发现过程一样。">
        <img style="width:100px"
           slot="avatar"
           src="/cover.jpeg"
        />
        </a-card-meta>
        </a-card>
      </a-list-item>
      <a-list-item>
        <a-card :bordered="false" style="width:100%">
        <a-card-meta title="世上最深的恶意，是劝你再来一把" description="花一万能收回来的，叫投资，花完一万又一万的，只能叫败家。">
        <img style="width:100px"
           slot="avatar"
           src="/grow.jpeg"
        />
        </a-card-meta>
        </a-card>
      </a-list-item>
      </a-list>
      </template>
       </a-card>
       </a-card>
      </a-col>
    </a-row>
  </page-view>
</template>

<script>
import { STable } from '@/components'
import { PageView } from '@/layouts'
import Fuse from 'fuse.js'
import md5 from 'md5'
import ARow from "ant-design-vue/es/grid/Row";
import ACol from "ant-design-vue/es/grid/Col";
import {timeFix} from '@/utils/util'
import {mapGetters} from 'vuex'
import {Button} from 'ant-design-vue'
import HeadInfo from '@/components/tools/HeadInfo'
import {Radar} from '@/components'
import {getRoleList, getServiceList, modifyPassword} from '@/api/manage'
import AFormItem from "ant-design-vue/es/form/FormItem";
const columns = [
    {
      dataIndex: 'number',
      key: 'number',
      slots: { title: 'customTitle' },
      scopedSlots: { customRender: 'number' },
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
      number: 1750001,
      name: '林一',
      nickname: '依依',
    },
 ]
export default {
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
        data,
        columns,
        visible: false,
        confirmLoading: false,
        pagination: {
          onChange: page => {
            console.log(page);
          },
          pageSize: 3,
        },
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
    methods: {
      onTabChange(key, type) {
        console.log(key, type);
        this[type] = key;
      },
      showModal() {
        this.visible = true;
      },
      handleOk(e) {
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
    },
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