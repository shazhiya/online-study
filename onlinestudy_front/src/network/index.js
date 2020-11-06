import axios from 'axios'
const baseURL = 'back/'
const back = axios.create({
    baseURL,
    headers: {
        contentType : "application/json;charset=UTF-8"
    }
})
back.defaults.withCredentials = true
export default back