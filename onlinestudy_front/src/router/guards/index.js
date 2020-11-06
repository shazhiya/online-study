import loginCheck from './login.check'

const beforeEach = (to,from,next) => {
    if(loginCheck(to,from,next)) return
    next()
}

export {
    beforeEach
}
