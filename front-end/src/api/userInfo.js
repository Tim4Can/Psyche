import {axios} from "@/utils/request";

const api = {
  modifyPassword: '/user/modifyPwd',
  myTreeholes: '/user/myTreeholes',
  myLike: '/user/myLike',
  getInfo: '/user/info',
}

export function modifyPwd (data) {
  return axios({
    url: api.modifyPassword,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function getInfo (data) {
  return axios({
    url: api.getInfo,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function getMyPost (data) {
  return axios({
    url: api.myTreeholes,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function getMyLike (data) {
  return axios({
    url: api.myLike,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}