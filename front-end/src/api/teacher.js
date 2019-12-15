import { axios } from '@/utils/request'

const api = {
  allTeacher: '/teacher/allTeacher',
  teacherDetail: 'teacher/teacherDetail'
}

export default api

export function getTeacher (data) {
  return axios({
    url: api.allTeacher,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function postTeacherDetail (data) {
  return axios({
    url: api.teacherDetail,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}