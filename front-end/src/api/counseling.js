import { axios } from '@/utils/request'

const api = {
  cancel: '/Counseling/cancel',
  myReserve: 'Counseling/myReserve',
  schedule: 'Counseling/schedule',
}

export default api

export function getMyReserve (data) {
  return axios({
    url: api.myReserve,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function cancelAppointment (data) {
  return axios({
    url: api.cancel,
    method: 'post',
    data: data,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

export function chooseTime (parameter) {
  return axios({
    url: api.schedule,
    method: 'post',
    data: parameter,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    }
  })
}

