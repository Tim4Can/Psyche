<template>
  <page-view title="老师信息">
    <a-card>
     <detail-list size="small" :col="1" class="detail-layout">
        <detail-list-item term="老师姓名">{{this.details.name}}</detail-list-item>
       <detail-list-item term="详细描述">{{this.details.introduction}}</detail-list-item>
       <detail-list-item term="咨询地址">{{this.details.address}}</detail-list-item>
      </detail-list>
    </a-card>
  </page-view>

</template>

<script>
import { mixinDevice } from '@/utils/mixin'
import { PageView } from '@/layouts'
import DetailList from '@/components/tools/DetailList'
import {getTeacher} from '@/api/teacher'
import ACol from "ant-design-vue/es/grid/Col";
import {mapGetters} from 'vuex'

const DetailListItem = DetailList.Item
console.log("DetailListItem",DetailListItem)

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

      details: this.$route.params.details,

    }
  },
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