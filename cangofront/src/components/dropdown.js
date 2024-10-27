import React, { useEffect, useState } from 'react';
import axios from 'axios';

function CompaniesListDropDown() {
    const [companies, setCompanies] = useState([]);

    useEffect(() => {
        // Fetch data from Spring Boot API
        axios.get('http://localhost:8080/Company/FindAll')
            .then(response => {
                setCompanies(response.data);
            })
            .catch(error => {
                console.error('Error fetching companies:', error);
            });
    }, []);

    return (
        <div>
            <h2>Company List</h2>
            <select>
                <option value="">Select a company</option>
                {companies.map(company => (
                    <option key={company.id} value={company.id}>
                        {company.name}
                    </option>
                ))}
            </select>
        </div>
    );
}

export default CompaniesListDropDown;