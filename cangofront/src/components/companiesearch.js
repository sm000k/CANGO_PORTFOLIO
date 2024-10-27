import React, { useState, useEffect } from 'react';
import axios from 'axios';

function CompaniesSearch() {
    const [searchTerm, setSearchTerm] = useState('');       // User's search term
    const [filteredCompanies, setFilteredCompanies] = useState([]); // Results from backend
    const [isDropdownVisible, setIsDropdownVisible] = useState(false); // Dropdown visibility

    // Fetch matching companies from the backend when searchTerm changes
    useEffect(() => {
        if (searchTerm) {
            // Make a request to the backend to fetch companies by name
            axios.get(`http://localhost:8080/Company/Search?name=${searchTerm}`)
                .then(response => {
                    setFilteredCompanies(response.data);  // Set results from the backend
                    setIsDropdownVisible(response.data.length > 0); // Show dropdown if results
                })
                .catch(error => {
                    console.error('Error fetching companies:', error);
                    setIsDropdownVisible(false);
                });
        } else {
            setFilteredCompanies([]); // Clear results if search term is empty
            setIsDropdownVisible(false); // Hide dropdown if search term is cleared
        }
    }, [searchTerm]);

    const handleSelectCompany = (companyName) => {
        setSearchTerm(companyName);  // Set selected name in search bar
        setIsDropdownVisible(false); // Hide dropdown after selection
    };

    return (
        <div style={{ width: '100%', maxWidth: '300px', position: 'relative' }}>
            <h2>Search Companies</h2>

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

export default CompaniesSearch;