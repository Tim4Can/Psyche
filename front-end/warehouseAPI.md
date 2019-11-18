# 仓库API(warehouseAPI)

```
// 该API接收非空仓库,展示在预览页面
name: getWarehousePreview
url: api/warehouse/preview
method: 'get'

return: {
  'data': [
    {
      'id': 'a0001', // 代表ID, string
      'icon': 0, // 代表图片路径, URL(string)
      'name': '嘉定仓库', // 代表名称, string
      'address': '嘉定区' // 代表地址, string
    },
    {
      'id': 'b0002',
      'icon': 1,
      'name': '四平仓库',
      'address': '杨浦区'
    },
    {
      'id': 'c0003',
      'icon': 2,
      'name': '五角场仓库',
      'address': '杨浦区'
    }
  ]
}
```

```
// 该API接收以ID为Key的仓库的详细信息,展示在detail页面的head处
name: postWarehouseDetail
url: api/warehouse/detail
method: 'post'
data: ID //  string, 发送详细的仓库ID, 存放在请求的body处, 请求返回仓库的详细信息

return: {
  'data': {
    'name': '四平仓库', // 该仓库的名称
    'address': '杨浦区', // 该仓库的地区
    'detailAddress': '四平路1239号' //该仓库的详细地址
  }
}
```

```
// 该API接收所有的仓库的地址(区号),以便前端以地址进行筛选
name: getAllAddress
url: api/warehouse/allAddress
method: 'get'

return: { // 请求的返回值为一个数组,存放所有的有仓库的地址
  'data': [
      '杨浦区', // string
      '嘉定区'
  ]
}
```

```
// 该API接收所有可以调度到的仓库(to), 用于调出到该仓库
name: getAllWarehouse
url: api/warehouse/allWarehouse
method: 'get'

return: { // 请求的返回值是一个数组,存放所有的仓库名字而不是ID, 用于调度.此处请确保仓库名是key
  'data': {
    '嘉定仓库', // string,
    '四平仓库',
    '五角场仓库'
  }
}
```

```
// 该API接收所有以ID为Key的仓库的货物信息
name: postGoods
url: api/warehouse/goods
method: 'post'
data: ID // string, 为仓库的ID, 存放在整个请求的body处, 请求返回ID的仓库的所有器材以及配件信息

return: {// 请求的返回值是两个数组,一个名为 accessory, 一个名为 equipment
  'data': {
    accessory: [
      {
        'id': 'a0001', // key string
        'model': 'Ryzen3700', // key, string
        'type': 'Accessory', // string
        'number': 1000 // int
      },
      {
        'id': 'a0001', // key string
        'model': 'Ryzen3900',
        'type': 'Accessory',
        'number': 2000
      },
    ],
    equipment: [
      {
        'id': 'e0001', // key string
        'model': 'GTX1080', // string
        'type': 'Equipment', // string
      },
      {
        'id': 'e0002',
        'model': 'GTX2080',
        'type': 'Equipment',
      }
    ]
  }
}
```

```
// 该API用于进行货物调度
name: postSchedule
url: api/warehouse/schedule
method: 'post'

// 传给后端的data有两种
// 一种的type属性是'Equipment'
// 一种的type属性是'Accessory'
// 在请求的body中
// 应为json格式,但是在我本地模拟后端的时候数据是string的格式,可能需要toJSON
data: {
    type: 'Accessory', // string
    model: 'GTX2080', // string
    from: '嘉定仓库', // string
    to: '四平仓库', //string
    num: 1 // number
}
data: {
    type: 'Equipment', // string
    id: 'A000001', // string 
    from: '五角场仓库', // string 
    to: '嘉定仓库' // string
}

return: {
    // 返回修改后的仓库数据
    // 参见postGoods
    // 但是只需要一个数组, 如果post的是Accessory,只需返回Accessory数组
}
```



