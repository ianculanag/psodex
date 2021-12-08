import React, { Component } from 'react';

import { Card, Form, Button, Row, Col, InputGroup, FormControl } from 'react-bootstrap';

export default class Account extends Component {
    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Add Account</Card.Header>
                <Card.Body>
                    <Form>
                        <Row className="mb-3">
                            <Form.Group as={Col}>
                                <Form.Label>Account Name</Form.Label>
                                <Form.Control type="text" placeholder="Enter the Account Name" />
                            </Form.Group>

                            <Form.Group as={Col}>
                                <Form.Label>Account Number</Form.Label>
                                <Form.Control type="text" placeholder="Enter the Account Number" />
                            </Form.Group>
                        </Row>

                        <Form.Group className="mb-3">
                            <Form.Label>Description</Form.Label>
                            <Form.Control as="textarea" placeholder="Provide a short description of the account" />
                        </Form.Group>

                        <Col xs="auto" className="mb-3">
                            <Form.Label>
                                Initial Amount
                            </Form.Label>
                            <InputGroup className="mb-2">
                                <InputGroup.Text>₱</InputGroup.Text>
                                <FormControl id="inlineFormInputGroup" placeholder="00.00" />
                            </InputGroup>
                        </Col>

                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
        );
    }
}