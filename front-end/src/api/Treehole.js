import { axios } from '@/utils/request'

const api = {
  allPost: '/Treehole/allPost',
  postDetail: '/Treehole/detail',
  sendTreehole: 'Treehole/sendTreehole',
  deleteTreehole: 'Treehole/deleteTreehole',
  sendComment: 'Treehole/sendComment',
}

export default api

export function getPost (data) {
  return axios({
    url: api.allPost,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function postDetail(data) {
  return axios({
    url: api.postDetail,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function addTreehole(parameter) {
  return axios({
    url: api.sendTreehole,
    method: 'post',
    data: parameter,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function deleteTreehole (data) {
  return axios({
    url: api.deleteTreehole,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function sendComment(data) {
  return axios({
    url: api.sendComment,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}
