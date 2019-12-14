<template>
  <page-view title="老师信息">
    <div>
      <div class="ant-pro-pages-list-projects-cardList">
        <a-list :loading="loading" :data-source="data" :grid="{ gutter: 24, xl: 4, lg: 3, md: 3, sm: 2, xs: 1 }"
                :pagination="pagination">
          <a-list-item slot="renderItem" slot-scope="item">
            <a-card class="ant-pro-pages-list-projects-card" hoverable :loading="loading">
              <img slot="cover" :src="item.headPortrait" :alt="item.title"/>
              <a-card-meta :title="'老师姓名：'+item.name">
                <template slot="description">
                  <ellipsis :length="70">{{ item.introduction }}</ellipsis>
                </template>
              </a-card-meta>
              <div class="cardItemContent" style="">
                <router-link :to="{ name: 'teacherDetail', params:{ id: item.id} }">预约</router-link>
              </div>
            </a-card>
          </a-list-item>
        </a-list>
        <template style="right">
          <a-pagination @change="onChange" :current="current" :total="totalPage" />
        </template>
      </div>
    </div>
  </page-view>
</template>

<script>
import moment from 'moment'
import { TagSelect, StandardFormRow, Ellipsis, AvatarList } from '@/components'
import Fuse from 'fuse.js'
import { getTeacher } from '@/api/teacher'
import {PageView} from '@/layouts'


var pageData = null
const TagSelectOption = TagSelect.Option
const AvatarListItem = AvatarList.AvatarItem

export default {
  components: {
    AvatarList,
    AvatarListItem,
    Ellipsis,
    TagSelect,
    TagSelectOption,
    StandardFormRow,
    PageView
  },
  data () {
    return {
      data: [],
      allData: [],
      loading: true,
      current: 1,
      total: '',
    }
  },
  filters: {
    fromNow (date) {
      return moment(date).fromNow()
    }
  },
  created () {
    this.getList()
  },
  methods: {
    onChange(current){
        this.current=current;
        getTeacher(this.current).then(response => {
        console.log('sssss',response.data.teacher)
        this.allData = response.data
        this.loading = false
        this.data = this.allData.teacher
        this.totalPage=this.allData.totalPage
      })
    },
    getList () {
          // this.$http.get('/list/article', { params: { count: 12 } }).then(res => {
          //   console.log('res', res)
          //   this.data = res.result
          //   this.loading = false
          //   pageData = this.data
          // })
    getTeacher(this.current).then(response => {
        console.log('sssss',response.data.teacher)
        this.allData = response.data
        this.loading = false
        this.data = this.allData.teacher
        this.totalPage=this.allData.totalPage
      })

    },

  }
}
</script>

<style lang="less" scoped>
.button {
    margin-top: 1rem
  }
.ant-pro-components-tag-select {
  /deep/ .ant-pro-tag-select .ant-tag {
    margin-right: 24px;
    padding: 0 8px;
    font-size: 14px;
  }
}
.ant-pro-pages-list-projects-cardList {
  margin-top: 24px;

  /deep/ .ant-card-meta-title {
    margin-bottom: 4px;
  }

  /deep/ .ant-card-meta-description {
    height: 66px;
    overflow: hidden;
    line-height: 22px;
  }

  .cardItemContent {
    display: flex;
    height: 20px;
    margin-top: 16px;
    margin-bottom: -4px;
    line-height: 20px;

    > span {
      flex: 1 1;
      color: rgba(0,0,0,.45);
      font-size: 12px;
    }

    /deep/ .ant-pro-avatar-list {
      flex: 0 1 auto;
    }
  }

}
</style>
