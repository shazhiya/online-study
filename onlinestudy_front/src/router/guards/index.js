import loginCheck from './login.check'
import notFound from './notFound'
import reload from './reload'

const beforeEach = (to,from,next) => {
    if(loginCheck(to,from,next)) return
    if(notFound(to,from,next)) return
    next()
    reload(to,from)
}

export {
    beforeEach
}
