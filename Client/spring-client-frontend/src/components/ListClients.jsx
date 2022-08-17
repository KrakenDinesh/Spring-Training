import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import ClientService from '../services/ClientService'
const ListClients = () => {

    const [client, setClient] = useState([]);

    useEffect(() => {

        getAllClient();
    }, [])

    const getAllClient = () => {
        ClientService.getAllClient().then((response) => {
            setClient(response.data)
            console.log(response.data);
        }).catch(error => {
            console.log(error);
        })
    }

    const deleteClient = (clientId) => {
        ClientService.deleteEmployee(clientId).then((response) => {
            getAllClient();

        }).catch(error => {
            console.log(error);
        })
    }

    return (
        <div className="container">
            <h2 className="text-center"> List Client </h2>
            <Link to="/add-client" className="btn btn-primary mb-2" > Add Client </Link>
            <table className="table table-bordered table-striped">
                <thead>
                    <th> Client Id </th>
                    <th>  Name </th>
                    <th> Email Id </th>
                    <th> Actions </th>
                </thead>
                <tbody>
                    {
                        client.map(
                            client =>
                                <tr key={client.id}>
                                    <td> {client.id} </td>
                                    <td> {client.name} </td>
                                    <td>{client.emailId}</td>
                                    <td>
                                        <Link className="btn btn-info" to={`edit-client/${client.id}`} >Update</Link>
                                        <button className="btn btn-danger" onClick={() => deleteClient(client.id)}
                                            style={{ marginLeft: "10px" }}> Delete</button>
                                    </td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListClients