import back from "./index"

function upload(file,type) {
    let param = new FormData()
    param.append('file', file)
    let config = {
        headers: { 'Content-Type': 'multipart/form-data' }
    }
    return back.post(`file/${type}/upload`,param,config)
}

export default upload