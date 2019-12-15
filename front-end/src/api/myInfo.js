import {axios} from "@/utils/request";

const api = {
  myTreeholes: '/myInfo/myTreeholes',
  myLike: '/myInfo/myLike',
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