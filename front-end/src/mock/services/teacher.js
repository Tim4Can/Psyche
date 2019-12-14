import Mock from 'mockjs2'


const allTeacher = (data) => {
  let teacher= {
    '0': [
      {
        'id': '1',
        'name': '李一',
        'headPortrait': '/avatar2.jpg',
        'type': '修理类型：2',
        'state': '0',
        'introduction': '被看见、被听见、被理解、被接受。',
        'address': '同济大学心理咨询室',
        'telNumber': '12332532',
      },
        {
          'id': '2',
          'name': 'ww',
          'headPortrait': '/avatar.jpg',
          'type': '修理类型:2',
          'state': '1',
          'introduction': '被看见、被听见、被理解、被接受。',
          'stuffNeeded': '齿轮 GPX x3',
          'telNumber': '18332532',

        },

        {
          'id': '3',
          'name': 'vf',
          'headPortrait': '/avatar.jpg',
          'type': '修理类型:2',
          'state': '2',
          'introduction': '被看见、被听见、被理解、被接受。',
          'stuffNeeded': '齿轮 GPX x3',
          'telNumber': '12332532',
        },

        {
          'id': '4',
          'name': 'fh',
          'headPortrait': '/avatar.jpg',
          'type': '修理类型:2',
          'state': '0',
          'introduction': '被看见、被听见、被理解、被接受。',
          'stuffNeeded': '齿轮 GPX x3',
          'telNumber': '12332532',
        },

        {
          'id': '5',
          'name': 'fff',
          'headPortrait': '/avatar.jpg',
          'type': '修理类型:2',
          'state': '1',
          'introduction': '把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
          'stuffNeeded': '齿轮 GPX x3',//报修单详细信息部分的器件需求部分
          'telNumber': '12332532',//报修用户的电话
        },

        {
          'id': '6',
          'name': 'ddd',
          'headPortrait': '/avatar.jpg',
          'type': '修理类型:2',
          'state': '2',
          'introduction': '把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
          'stuffNeeded': '齿轮 GPX x3',//报修单详细信息部分的器件需求部分
          'telNumber': '12332532',//报修用户的电话
        },

        {
          'id': '7',
          'name': 'sfgd',
          'headPortrait': '/avatar.jpg',
          'type': '修理类型:2',
          'state': '0',
          'introduction': '把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
          'stuffNeeded': '齿轮 GPX x3',//报修单详细信息部分的器件需求部分
          'telNumber': '12332532',//报修用户的电话
        },

        {
          'id': '8',
          'name': 'dg',
          'headPortrait': '/avatar.jpg',
          'type': '修理类型:2',
          'state': '1',
          'introduction': '把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
          'stuffNeeded': '齿轮 GPX x3',//报修单详细信息部分的器件需求部分
          'telNumber': '12332532',//报修用户的电话
        },
    ],
    '1':[
      {
        'id': '9',
        'name': 'sgr',
        'headPortrait': '/avatar.jpg',
        'type': '修理类型:2',
        'state': '2',
        'introduction': '把手损坏，油漆脱落',//报修单详细信息的损坏描述部分
        'address': '齿轮 GPX x3',//报修单详细信息部分的器件需求部分
        'telNumber': '12332532',//报修用户的电话
       }
       ]
  }
  return {
      data: teacher[data.body]
  }

}
const teacherDetail = ( data ) => {
  let detail = {
    '1':
      {
       'id': '1',
      'name': '李一',
      'headPortrait': '/avatar2.jpg',
      'type': '修理类型：2',
      'state': '0',
      'introduction':'被看见、被听见、被理解、被接受。',
      'address':'同济大学心理咨询室',
      'telNumber':'12332532',
      },
    '2':
      {
        'id': '1',
        'name': '李一',
        'headPortrait': '/avatar2.jpg',
        'type': '修理类型：2',
        'state': '0',
        'introduction':'被看见、被听见、被理解、被接受。',
        'address':'同济大学心理咨询室',
        'telNumber':'12332532',

      },
    '3':
      {
        'id': '1',
        'name': '李一',
        'headPortrait': '/avatar2.jpg',
        'type': '修理类型：2',
        'state': '0',
        'introduction':'被看见、被听见、被理解、被接受。',
        'address':'同济大学心理咨询室',
        'telNumber':'12332532',
      },

  }
  return {
    data: detail[data.body],
  }
}

Mock.mock(/\/teacher\/allTeacher/, 'post', allTeacher)
Mock.mock(/\/teacher\/teacherDetail/, 'post', teacherDetail)