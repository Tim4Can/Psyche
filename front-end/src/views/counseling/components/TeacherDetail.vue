<template>
    <page-view title="老师详情">
    <a-card>
    <detail-list :col="1" class="detail-layout">
      <img style="width:60px" slot="avatar" src="this.details.headPortrait" />
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
import {getTeacherDetail} from '@/api/teacher'
import ACol from "ant-design-vue/es/grid/Col";
import {mapGetters} from 'vuex'



const DetailListItem = DetailList.Item
console.log("DetailListItem",DetailListItem)


export default {
    inject: ['reload'],
    created(){
      this.result.DSTid = this.userInfo.id

      this.details = this.$route.params.details
      this.result.RSTid = this.details.title
      this.eqID = this.details.eqID
      console.log("this.details.eqID",this.details.EqId)
      getRepairSheetDetail().then((response)=>{
        console.log("response",response.data)
        this.eqType = response.data.equipType
        this.acType = response.data.accessory
        this.stfList = response.data.staff
        console.log("eqType",this.eqType[0])
        console.log("acType",this.acType)
        console.log("acType",this.stfList)
      })

    },
    name: 'teacherDetail',
    components: {
      ACol,
    PageView,

    DetailList,
    DetailListItem
  },
    mixins: [mixinDevice],
  data () {
    return {
      activeTabKey: '1',
      rpData:[],
      columns,
      eqType:[],
      acType:[],
      stfList:[],
      eqID:'',
      visible2:true,
      eqSelected:false,
      submit:false,
      result:{
        'DSTid':'',
        'RSTid':'',
        'stfId':'',
        'ls':[]
      },
      eqInfo:'',
      tempRow:{
        'type':'',
        'model':'',
        'number':'',
        'statue':'',
        'key':1
      },
      tempKey:1,
      details: this.$route.params.details,
      eqNum:'',
      tempEq:'',
      tempAc:'',
      acNum:'',
      columns,
      visible:false,
      info:'',
    }
  },
  filters: {
    statusFilter (status) {
      const statusMap = {
        'agree': '成功',
        'reject': '驳回'
      }
      return statusMap[status]
    },
    statusTypeFilter (type) {
      const statusTypeMap = {
        'agree': 'success',
        'reject': 'error'
      }
      return statusTypeMap[type]
    }
  },
  computed:{
    userInfo() {
        return this.$store.getters.userInfo
      },
    qualified:function(){
      if(this.details.state == '0'||this.details.state=='2'){
        return "disabled"
      }
    },
    qualifiedForEq:function(){
      console.log("eqselected",this.eqSelected)
      if(this.details.state == '0'||this.details.state=='2'||this.eqSelected){
        return "disabled"
      }
    },
    successRepair:function(){
      if(this.result.stfId === ''){
        return "error"
      }
      else{
        return "success"
      }
    },
    maxEqNum:function(){
      if(this.tempEq === ''){
        return
      }
      var tempEqSelect = parseInt(this.tempEq)
      var tempEqNum = this.eqType[tempEqSelect].number
      console.log("maxNum",tempEqNum)
      return tempEqNum
      //let temp = this.eqType[this.tempEq-'0'].number-'0'

    },
    maxAcNum:function(){
      if(this.tempAc === ''){
        return
      }
      var tempAcSelect = parseInt(this.tempAc)
      var tempAcNum = this.acType[tempAcSelect].number
      console.log("maxNum",tempAcNum)
      return tempAcNum
      //let temp = this.eqType[this.tempEq-'0'].number-'0'

    },
    compare:function(){
      if(this.tempEq === ''){
        return "success"
      }
      if(!(/(^[1-9]\d*$)/.test(this.eqNum))){
        return "error"
      }
      var tempEqSelect = parseInt(this.tempEq)
      var tempEqNum = this.eqType[tempEqSelect].number
      console.log("maxNum",tempEqNum)
      if(this.eqNum!==''){
        var inputTemp = parseInt(this.eqNum)
        console.log("input",inputTemp)
        if(inputTemp > tempEqNum){
          return "error"
        }
        else{
          return "success"
        }
      }
      return "error"
      //let temp = this.eqType[this.tempEq-'0'].number-'0'

    },
    compareAc:function(){
      if(this.tempAc === ''){
        return "success"
      }
      if (!(/(^[1-9]\d*$)/.test(this.acNum))){
        return "error"
      }
      var tempAcSelect = parseInt(this.tempAc)
      var tempAcNum = this.acType[tempAcSelect].number
      console.log("maxNum2",tempAcNum)
      if(this.acNum!==''){
        var inputTemp = parseInt(this.acNum)
        console.log("input2",inputTemp)
        if(inputTemp > tempAcNum){
          return "error"
        }
        else{
          return "success"
        }
      }
      return "error"
      //let temp = this.eqType[this.tempEq-'0'].number-'0'

    },
    text:function(){
      if(this.tempEq !== ''){
        return "最大数量:"+this.maxEqNum
      }
      else{
        return "每次仅允许调度一个器材"
      }
    },
    textAc:function(){
      if(this.tempAc !== ''){
        return "最大数量:"+this.maxAcNum
      }
      else{
        return "请输入数量"
      }
    },
    qualifiedforButton:function(){
    if(this.details.state == '0'||this.details.state=='2'||this.eqSelected){
        return "disabled"
      }
    if(this.tempEq === ''||this.result.stfId === ''){
      return "disabled"
    }
  },
  qualifiedforButtonAc:function(){
    if(this.details.state == '0'||this.details.state=='2'){
        return "disabled"
      }
    if(this.tempAc === ''||this.acNum === ''||this.result.stfId === ''){
      return "disabled"
    }
  },
  qualifiedforSubmit:function(){
    console.log("length",this.result.ls.length)
    if(this.result.ls.length === 0||this.submit){
        return "disabled"
      }
  },
  },
  methods:{
    handleOK(){

      this.visible = false
      this.result.stfId = "ST"+this.result.stfId
      console.log("this.result.stfId",this.result.stfId)
      submitScheduleDetail(this.result).then((response) =>{
        this.info = response.info
        if(this.info === 'ok'){
          this.submit = true
          this.details.state = '2'
          this.$notification.open({
          message: '调度成功',
          description: '本条报修单调度成功',
          icon: <a-icon type="check" style="color: #108ee9" />,
        });
        }
      })
    },
    onClickSubmit(){
      this.visible = true
    },
    handleStaffChange(value){
      this.result.stfId = value
      console.log("newId",this.result.stfId)
    },
    handleEqChange(value){
      this.tempEq = value
      console.log("newEq",this.tempEq)
    },
    handleAcChange(value){
      this.tempAc = value
      console.log("newAc",this.tempAc)
    },
    handleAddEq(){
      this.eqNum = '1'
      var tempEqSelect = parseInt(this.tempEq)
      var tempEqNum = this.eqType[tempEqSelect].number
      console.log("容量",tempEqNum)
      var inputTemp = parseInt(this.eqNum)
      console.log("需求",inputTemp)
      if(inputTemp > tempEqNum){
        this.$notification.open({
          message: '添加失败',
          description: '仓储不足，请先补充仓储器材',
          icon: <a-icon type="exclamation-circle" style="color: #108ee9" />,
        });
        return;
      }
      else{
          this.eqSelected = true
          console.log("rowls",this.result.ls)
          this.tempKey = this.tempKey + 1
          console.log("tempKey",this.tempKey)
          this.result.ls.push({
            'type': this.eqType[tempEqSelect].type,
            'model': this.eqType[tempEqSelect].model,
            'number': inputTemp,
            'statue':'器材',
            'key' : this.tempKey+1
          })
          this.eqNum = ''
          this.eqType[tempEqSelect].number = String(this.eqType[tempEqSelect].number-parseInt(inputTemp))
          console.log("eqNumber",this.eqType.number )
      }
    },
    handleAddAc(){
      if(!(/(^[1-9]\d*$)/.test(this.acNum))){
        this.$notification.open({
          message: '添加失败',
          description: '请输入合法的数字字符',
          icon: <a-icon type="exclamation-circle" style="color: #108ee9" />,
        });
        return;
      }
      var tempAcSelect = parseInt(this.tempAc)
      var tempAcNum = this.acType[tempAcSelect].number
      console.log("容量2",tempAcNum)
      var inputTemp = parseInt(this.acNum)
      console.log("需求2",inputTemp)
      if(inputTemp > tempAcNum){
        this.$notification.open({
          message: '添加失败',
          description: '仓储不足，请先补充仓储配件',
          icon: <a-icon type="exclamation-circle" style="color: #108ee9" />,
        });
        return;
      }
      else{
        console.log("rowls",this.result.ls)
           this.tempRow.key = this.tempKey+1
          this.tempKey = this.tempKey + 1
          console.log("tempKey",this.tempKey)
          this.result.ls.push({
            'type': this.acType[tempAcSelect].type,
            'model': this.acType[tempAcSelect].model,
            'number':inputTemp,
            'statue':'配件',
            'key' : this.tempKey+1
          })
          this.acNum = ''
          this.acType[tempAcSelect].number = String(this.acType[tempAcSelect].number-parseInt(inputTemp))
      }
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