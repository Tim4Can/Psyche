import Mock from 'mockjs2'
// url: 'treeHole/allPost'
//method: 'get'
//得到所有配件在仓库中的信息，包括modelID，类型，价格，数量，所在仓库
//
const allPost = (data) => {
  let treeHole = {
    '1': [
          {
            'id': '1',
            'title': '哈哈哈',
            'content': 'hzdifhdgfg',
            'sendTime': '2019-12-12',
            'headPortrait': '/avatar2.jpg',
            'key': 'tf-100',
            'model': 'model_1',
            'type': '履带',
            'price': 12,
            'num': 10,
            'warehouse': '嘉定仓库',
            'warehouseID': '1234567890'
          },
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait': '/avatar2.jpg',
        'key': 'tf-130',
        'model': 'model_2',
        'type': '螺丝',
        'price': 1,
        'num': 100,
        'warehouse': '五角场仓库',
        'warehouseID': '1234567890'
      },
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait': '/avatar2.jpg',
        'key': 'tf-140',
        'model': 'model_1',
        'type': '履带',
        'price': 12,
        'num': 10,
        'warehouse': '嘉定仓库',
        'warehouseID': '1234567890'
      },
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait':'/avatar2.jpg',
        'key': 'tf-150',
        'model': 'model_2',
        'type': '螺丝',
        'price': 1,
        'num': 100,
        'warehouse': '五角场仓库',
        'warehouseID': '1234567890'
      },
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait':'/avatar2.jpg',
        'key': 'tf-160',
        'model': 'model_1',
        'type': '履带',
        'price': 12,
        'num': 10,
        'warehouse': '嘉定仓库',
        'warehouseID': '1234567890'
      },
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait':'/avatar2.jpg',
        'key': 'tf-210',
        'model': 'model_2',
        'type': '螺丝',
        'price': 1,
        'num': 100,
        'warehouse': '五角场仓库',
        'warehouseID': '1234567890'
      },
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait':'/avatar2.jpg',
        'key': 'tf-270',
        'model': 'model_1',
        'type': '履带',
        'price': 12,
        'num': 10,
        'warehouse': '嘉定仓库',
        'warehouseID': '1234567890'
      },
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait':'/avatar2.jpg',
        'key': 'tf-280',
        'model': 'model_2',
        'type': '螺丝',
        'price': 1,
        'num': 100,
        'warehouse': '五角场仓库',
        'warehouseID': '1234567890'
      },],
    '2':[
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait':'/avatar2.jpg',
        'key': 'tf-280',
        'model': 'model_2',
        'type': '螺丝',
        'price': 1,
        'num': 100,
        'warehouse': '五角场仓库',
        'warehouseID': '1234567890'
      },
      {
        'id': '2',
        'title': '哈哈哈',
        'content': 'hzdifhdgfg',
        'sendTime': '2019-12-12',
        'headPortrait':'/avatar2.jpg',
        'key': 'tf-280',
        'model': 'model_2',
        'type': '螺丝',
        'price': 1,
        'num': 100,
        'warehouse': '五角场仓库',
        'warehouseID': '1234567890'
      },]
  }
  return {
      data: {
        totalPage:50,
        post:treeHole[data.body]
      }
  }
}
//url: '/accessory/addAccessory'
//method: 'post'
//上传增加配件信息，包括accessoryID，num,warehouse
const addPost = () => {
  return {
    data: 'successful'
  }
}
//url: '/accessory/allWarehouse'
//method: 'get'
//请求所有仓库名字

// url: /accessory/allKind'
//method: 'get'
//请求所有配件ID及对应型号
/*const allKind = () => {
  return {
    data:[
      {
        accessory: 'tf-100',
        model: 'model_01'
      },
      {
        accessory: 'tf-200',
        model: 'model_02'
      },
      {
        accessory: 'tf-300',
        model: 'model_03'
      }
    ]
  }
}*/
//url:'/accessory/allType'
//method: 'get'
//请求所有配件类型
/*const allType = () => {
  return {
    data:[
      {
        value:'履带'
      },{
        value:'螺丝'
      }
    ]
  }
}*/
const detail = (data) => {
  let detail={
    '1':
      {
        'id': '1',
            'title': '哈哈哈',
            'content': 'hzdifhdgfg',
            'sendTime': '2019-12-12',
            'headPortrait': '/avatar2.jpg',
      },
    '2':
      {
        'id': '2',
            'title': '哈哈哈',
            'content': 'hzdifhdgfg',
            'sendTime': '2019-12-12',
            'headPortrait': '/avatar2.jpg',
      }
  }
  return {
    data: detail[data.body],
  }

}
const comment = (data) => {
  let detail={
    '1':
      [{
        'id': '1',
        'speakerName': '林一',
        'content': 'hhhhhhhh',
        'sendTime': '2019-12-12',
        'speaker_headPortrait': '/avatar2.jpg',
        'index':'1',
      },
        {
          'id': '1',
          'speakerName': '林一',
          'content': 'hhhhhhhh',
          'sendTime': '2019-12-12',
          'speaker_headPortrait': '/avatar2.jpg',
          'index':'2',
        },
        {
          'id': '1',
          'speakerName': '林一',
          'content': 'hhhhhhhh',
          'sendTime': '2019-12-12',
          'speaker_headPortrait': '/avatar2.jpg',
          'index':'3',
        },
        {
          'id': '1',
          'speakerName': '林一',
          'content': 'hhhhhhhh',
          'sendTime': '2019-12-12',
          'speaker_headPortrait': '/avatar2.jpg',
          'index':'4',
        },
      ],
    '2':
      [
        {
          'speakerName': '林二',
          'content': 'hhhhhhhh',
          'sendTime': '2019-12-12',
          'speaker_headPortrait': '/avatar2.jpg',
          'index':'5',
      },
        {
          'id': '1',
          'speakerName': '林一',
          'content': 'hhhhhhhh',
          'sendTime': '2019-12-12',
          'speaker_headPortrait': '/avatar2.jpg',
          'index':'6',
        },

      ]
  }
  return {
    data: {
      totalPage:50,
      comment:detail[data.body],
    }
  }

}


Mock.mock(/\/Treehole\/allPost/, 'post', allPost)
Mock.mock(/\/Treehole\/addPost/, 'post', addPost)
Mock.mock(/\/Treehole\/detail/, 'post', detail)
Mock.mock(/\/Treehole\/comment/, 'post', comment)


/*
Mock.mock(/\/accessory\/allWarehouse/, 'get', allWarehouse)
Mock.mock(/\/accessory\/allType/, 'get', allType)
Mock.mock(/\/accessory\/allKind/, 'get', allKind)*/
