import login from './request'

const loginApi = (data) => {
    return login.post({
        url: '/api/login',
        data
    })
}

export default loginApi