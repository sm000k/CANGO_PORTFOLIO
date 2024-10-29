import React, { useState } from 'react';
import { Form, Button, Container } from 'react-bootstrap';

function TextForm() {
    const [inputValue, setInputValue] = useState('');

    const handleChange = (event) => {
        setInputValue(event.target.value);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        alert(`Submitted text: ${inputValue}`);
    };
    return (
        <Container className="mt-5">
            <h2>Sample Form</h2>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formBasicText">
                    <Form.Label>Enter some text</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Enter text"
                        value={inputValue}
                        onChange={handleChange}
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="mt-3">
                    Submit
                </Button>
            </Form>
            {inputValue}
        </Container>
    );
}

export default TextForm;