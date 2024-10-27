import React, { useEffect, useState } from 'react';
import axios from 'axios';

function CompaniesList() {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        // Fetch data from Spring Boot API
        axios.get('http://localhost:8080/Company/FindAll')
            .then(response => {
                setUsers(response.data);
            })
            .catch(error => {
                console.error('Error fetching users:', error);
            });
    }, []);

    return (
        <div>
            <h2>User List</h2>
            <ul>
                {users.map(user => (
                    <li key={user.id}>{user.name} </li>
                ))}
            </ul>
        </div>
    );
}

export default CompaniesList;