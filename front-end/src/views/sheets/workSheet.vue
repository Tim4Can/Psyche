<template>
  <page-view title="我的预约">
    <div>
      <template>
        <a-table :columns="columns" :dataSource="data">
          <a slot="name" slot-scope="text" href="javascript:;">{{text}}</a>
          <span slot="customTitle"><a-icon type="smile-o" /> Name</span>
          <span slot="tags" slot-scope="tags">
            <a-tag
              v-for="tag in tags"
              :color="tag==='loser' ? 'volcano' : (tag.length > 5 ? 'geekblue' : 'green')"
              :key="tag"
            >
              {{tag.toUpperCase()}}
            </a-tag>
          </span>
          <span slot="action" slot-scope="text, record">
            <a-button type="primary">取消预约</a-button>
          </span>
        </a-table>
      </template>
    </div>
  </page-view>
</template>


<script>
import Fuse from 'fuse.js'
import Vue from 'vue'
import Lightbox from 'vue-easy-lightbox'
import { PageView } from '@/layouts'


Vue.use(Lightbox)
import { getWorkSheet, deleteWorkSheetRow } from '@/api/sheets'

const columns = [
    {
      dataIndex: 'name',
      key: 'name',
      slots: { title: 'customTitle' },
      scopedSlots: { customRender: 'name' },
    },
    {
      title: 'Time',
      dataIndex: 'time',
      key: 'time',
    },
    {
      title: 'Address',
      dataIndex: 'address',
      key: 'address',
    },
    {
      title: 'Tags',
      key: 'tags',
      dataIndex: 'tags',
      scopedSlots: { customRender: 'tags' },
    },
    {
      title: 'Action',
      key: 'action',
      scopedSlots: { customRender: 'action' },
    },
  ];

  const data = [
    {
      key: '1',
      name: '李一',
      time: '周二/14:00~15:00',
      address: 'New York No. 1 Lake Park',
      tags: ['nice'],
    },
    {
      key: '2',
      name: 'Jim Green',
      time: '周三/9:00~10:00',
      address: 'London No. 1 Lake Park',
      tags: ['NICE'],
    },
    {
      key: '3',
      name: 'Joe Black',
      time: '周五/9:00~10:00',
      address: 'Sidney No. 1 Lake Park',
      tags: ['cool'],
    },
  ];

export default {
  components: {
        PageView
      },
    data() {
      return {
        data,
        columns,
      };
    },
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

