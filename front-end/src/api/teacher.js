import { axios } from '@/utils/request'

const api = {
  allTeacher: '/teacher/allTeacher',
}

export default api

export function getTeacher () {
  return axios({
    url: api.allTeacher,
    method: 'get'
  })
}
