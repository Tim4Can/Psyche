<template>
  <page-view title="老师信息">
    <div>
      <div class="ant-pro-pages-list-projects-cardList">
        <a-list :loading="loading" :data-source="data" :grid="{ gutter: 24, xl: 4, lg: 3, md: 3, sm: 2, xs: 1 }"
                :pagination="pagination">
          <a-list-item slot="renderItem" slot-scope="item">
            <a-card class="ant-pro-pages-list-projects-card" hoverable :loading="loading">
              <img slot="cover" :src="item.headPortrait" :alt="item.title"/>
              <template class="ant-card-actions" slot="actions">
              </template>
              <a-card-meta :title="'老师姓名：'+item.name">
                <template slot="description">
                  <ellipsis :length="70">{{ item.introduction }}</ellipsis>
                </template>
              </a-card-meta>
              <div class="cardItemContent" style="">
                <span>{{ item.updatedAt | fromNow }}</span>
                <router-link :to="{ name: 'teacherDetail', params:{ details: item} }">
                  <a-button type="primary" block>预约</a-button>
                </router-link>
              </div>
            </a-card>
          </a-list-item>
        </a-list>
      </div>
    </div>
  </page-view>
</template>

<script>
import moment from 'moment'
import { TagSelect, StandardFormRow, Ellipsis, AvatarList } from '@/components'
import Fuse from 'fuse.js'
import teacherDetail from './components/teacherDetail'
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
      pagination:{
        pageSize: 8,
        showTotal: (total, range) => {
          console.log("range",range)
          if(range[1] == 0){
            return `0-0 of 0 items`
          }
          return `${range[0]}-${range[1]} of ${total} items`
          },
        defaultCurrent: 1,
        showQuickJumper: true,
      },
      idFilterValue: '',
      selection: '',
      fusejsOptions: {
        shouldSort: true,
        tokenize: true,
        threshold: 1.0,
        location: 0,
        distance: 100,
        maxPatternLength: 32,
        minMatchCharLength: 1,
        keys: [
          "title",
          "description"
        ]

      },
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

   refreshTable() {
      this.loading = true
      getTeacher().then(response => {
      console.log('sssss',response.data)
      pageData = response.data
      this.loading = false
      this.data = pageData
      })

    },
    getList () {
          // this.$http.get('/list/article', { params: { count: 12 } }).then(res => {
          //   console.log('res', res)
          //   this.data = res.result
          //   this.loading = false
          //   pageData = this.data
          // })
    getTeacher().then(response => {
      console.log('sssss',response.data)
        pageData = response.data
        this.loading = false
        this.data = pageData
      })

    },

    filterOnce(){
      if(!this.idFilterValue){
        var result = pageData
      }
      else{
        var oldData = pageData
      var options = this.fusejsOptions
      var fuse = new Fuse(oldData, options)
      var result = fuse.search(this.idFilterValue)
      console.log(result)

      }
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
