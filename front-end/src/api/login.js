import api from './index'
import { axios } from '@/utils/request'

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