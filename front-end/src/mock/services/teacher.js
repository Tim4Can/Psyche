import Mock from 'mockjs2'


const allTeacher = () => {
  return {
    data: [{

      'name': '李一',
      'headPortrait': '/avatar2.jpg',
      'type': '修理类型：2',
      'state': '0',
      'introduction':'被看见、被听见、被理解、被接受。',
      'address':'同济大学心理咨询室',
      'telNumber':'12332532',
    },
      {

        'name': 'ww',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '1',
        'introduction':'被看见、被听见、被理解、被接受。',
        'stuffNeeded':'齿轮 GPX x3',
        'telNumber':'18332532',

      },
      {

        'name': 'vf',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '2',
        'introduction':'被看见、被听见、被理解、被接受。',
        'stuffNeeded':'齿轮 GPX x3',
        'telNumber':'12332532',
      },

      {

        'name': 'fh',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '0',
        'introduction':'被看见、被听见、被理解、被接受。',
        'stuffNeeded':'齿轮 GPX x3',
        'telNumber':'12332532',
      },

      {

        'name': 'fff',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '1',
        'introduction':'把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
        'stuffNeeded':'齿轮 GPX x3',//报修单详细信息部分的器件需求部分
        'telNumber':'12332532',//报修用户的电话
      },

      {

        'name': 'ddd',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '2',
        'introduction':'把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
        'stuffNeeded':'齿轮 GPX x3',//报修单详细信息部分的器件需求部分
        'telNumber':'12332532',//报修用户的电话
      },

      {

        'name': 'sfgd',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '0',
        'introduction':'把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
        'stuffNeeded':'齿轮 GPX x3',//报修单详细信息部分的器件需求部分
        'telNumber':'12332532',//报修用户的电话
      },

      {

        'name': 'dg',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '1',
        'introduction':'把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
        'stuffNeeded':'齿轮 GPX x3',//报修单详细信息部分的器件需求部分
        'telNumber':'12332532',//报修用户的电话
      },

      {

        'name': 'sgr',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '2',
        'introduction':'把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
        'stuffNeeded':'齿轮 GPX x3',//报修单详细信息部分的器件需求部分
        'telNumber':'12332532',//报修用户的电话
      }

    ],



  }
}

Mock.mock(/\/teacher\/allTeacher/, 'get', allTeacher)