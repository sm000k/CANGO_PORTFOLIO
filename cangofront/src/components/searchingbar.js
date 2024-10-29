import React, { useEffect, useState } from 'react';
import axios from 'axios';

function CompaniesList() {
    const [companies, setCompanies] = useState([]);        // All companies
    const [searchTerm, setSearchTerm] = useState('');       // User's search term
    const [filteredCompanies, setFilteredCompanies] = useState([]); // Filtered results
    const [isDropdownVisible, setIsDropdownVisible] = useState(false); // Dropdown visibility

    useEffect(() => {
        // Fetch all companies from the backend API
        axios.get('http://localhost:8080/Company/FindAll')
            .then(response => {
                setCompanies(response.data);  // Set companies list
            })
            .catch(error => {
                console.error('Error fetching companies:', error);
            });
    }, []);

    // Filter companies whenever searchTerm changes
    useEffect(() => {
        if (searchTerm) {
            // Filter companies based on the search term
            const filtered = companies.filter(company =>
                company.name.toLowerCase().includes(searchTerm.toLowerCase())
            );
            setFilteredCompanies(filtered);  // Set filtered list
            setIsDropdownVisible(filtered.length > 0); // Show dropdown if matches found
        } else {
            setFilteredCompanies([]); // Clear filtered list
            setIsDropdownVisible(false); // Hide dropdown if no search term
        }
    }, [searchTerm, companies]);

    const handleSelectCompany = (companyName) => {
        setSearchTerm(companyName);  // Set selected name in search bar
        setIsDropdownVisible(false); // Hide dropdown after selection
    };

    return (
        <div style={{ width: '100%', maxWidth: '300px', position: 'relative' }}>
            <h2>Company List</h2>

            {/* Search input bar */}
            <input
                type="text"
                placeholder="Search companies..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}  // Update search term
                onFocus={() => setIsDropdownVisible(filteredCompanies.length > 0)} // Show dropdown on focus if results
                style={{
                    width: '100%',
                    padding: '8px',
                    fontSize: '16px',
                    borderRadius: '4px',
                    border: '1px solid #ccc',
                    marginBottom: '8px' // Add space for dropdown below
                }}
            />

            {/* Custom dropdown list */}
            {isDropdownVisible && (
                <div style={{
                    border: '1px solid #ccc',
                    borderRadius: '4px',
                    position: 'absolute',
                    top: '100%',
                    width: '100%',
                    maxHeight: '150px',
                    overflowY: 'auto',
                    backgroundColor: '#fff',
                    zIndex: 1,
                    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
                }}>
                    {filteredCompanies.map(company => (
                        <div
                            key={company.id}
                            onClick={() => handleSelectCompany(company.name)} // Select company
                            style={{
                                padding: '8px',
                                cursor: 'pointer',
                                backgroundColor: '#fff',
                                borderBottom: '1px solid #eee',
                            }}
                            onMouseDown={(e) => e.preventDefault()} // Prevent blur on click
                        >
                            {company.name}
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
}

export default CompaniesList;
