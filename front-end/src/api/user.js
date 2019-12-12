import api from './index'
import { axios } from '@/utils/request'

const api = {
  modifyPassword: '/user/modifyPwd',
  myTreeholes: 'user/myTreeholes',
  myLike: 'user/myLike',
}

export function login(data) {
  return axios({
    url: '/User/login',
    method: 'post',
    data: data
  })
}

export function getInfo(data) {
  return axios({
    url: '/User/myInfos',
    method: 'get',
  })
}

export function logout() {
  return axios({
    url: '/User/loginOut',
    method: 'post',
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
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