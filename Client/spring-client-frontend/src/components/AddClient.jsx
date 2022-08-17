import React, {useState, useEffect} from 'react'
import {Link, useNavigate, useParams } from 'react-router-dom';

import ClientService from '../services/ClientService'

const AddClient = () => {
  const [name, setName] = useState('')
  const [emailId, setEmailId] = useState('')
  const history = useNavigate();
  const {id} = useParams();

  const saveOrUpdateClient = (e) => {
      e.preventDefault();
      const client = {name,emailId}
      if(id){
          ClientService.updateClient(id, client).then((response) => {
              history.push('/clients')
          }).catch(error => {
              console.log(error)
          })
      }else{
          ClientService.createClient(client).then((response) =>{

              console.log(response.data)
  
              history.push('/clients');
  
          }).catch(error => {
              console.log(error)
          })
      }
      
  }

  useEffect(() => {

      ClientService.getClientById(id).then((response) =>{
          setName(response.data.name)
          setEmailId(response.data.emailId)
      }).catch(error => {
          console.log(error)
      })
  }, [])

  const title = () => {

      if(id){
          return <h2 className = "text-center">Update Client</h2>
      }else{
          return <h2 className = "text-center">Add Client</h2>
      }
  }

  return (
      <div>
         <br /><br />
         <div className = "container">
              <div className = "row">
                  <div className = "card col-md-6 offset-md-3 offset-md-3">
                     {
                         title()
                     }
                      <div className = "card-body">
                          <form>
                              <div className = "form-group mb-2">
                                  <label className = "form-label"> Name :</label>
                                  <input
                                      type = "text"
                                      placeholder = "Enter name"
                                      name = "Name"
                                      className = "form-control"
                                      value = {name}
                                      onChange = {(e) => setName(e.target.value)}
                                  >
                                  </input>
                              </div>
                              <div className = "form-group mb-2">
                                  <label className = "form-label"> Email Id :</label>
                                  <input
                                      type = "email"
                                      placeholder = "Enter email Id"
                                      name = "emailId"
                                      className = "form-control"
                                      value = {emailId}
                                      onChange = {(e) => setEmailId(e.target.value)}
                                  >
                                  </input>
                              </div>

                              <button className = "btn btn-success" onClick = {(e) => saveOrUpdateClient(e)} >Submit </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                              <Link to="/clients" className="btn btn-danger"> Cancel </Link>
                          </form>

                      </div>
                  </div>
              </div>

         </div>

      </div>
  )
}

export default AddClient