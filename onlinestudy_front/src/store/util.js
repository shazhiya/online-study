import back from "../network";
import qs from 'qs'

function post(url,data,successCallback,stringify){
  if(stringify) data = qs.stringify(data)  
  return back
    .post(url,data)
    .then(successCallback)
    .catch(err=>{
      window.console.log(err)
      return err
    })
}

export default post
