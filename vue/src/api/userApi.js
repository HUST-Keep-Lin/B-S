import request from '@/utils/request'

export function GetData() {
  return request({
    url: '/sys/running/show',
    method: 'get',
    timeout: 20000

  })
}

export function GetError() {
  return request({
    url: '/sys/running/show2',
    method: 'get',
    timeout: 20000
  })
}
