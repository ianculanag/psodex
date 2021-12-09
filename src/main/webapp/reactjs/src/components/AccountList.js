import React, { Component } from 'react';

import { Card, Table, ButtonGroup, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faList, faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';

import axios from 'axios';

export default class AccountList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            accounts: []
        };
    }

    componentDidMount() {
        this.findAllAccounts();
    }

    findAllAccounts() {
        axios.get("http://localhost:3030/accounts")
            .then(response => response.data)
            .then((data) => {
                this.setState({ accounts: data });
            });
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faList} /> Account List</Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant="dark">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Account Name</th>
                                <th>Account Number</th>
                                <th>Description</th>
                                <th>Issuing Bank</th>
                                <th>Initial Balance</th>
                                <th>Current Balance</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.accounts.length === 0 ?
                                <tr align="center">
                                    <td colspan="6">Books Avaialble.</td>
                                </tr>
                                :
                                this.state.accounts.map((account) => (
                                    <tr key={account.id}>
                                        <td>{account.id}</td>
                                        <td>{account.name}</td>
                                        <td>{account.accountNumber}</td>
                                        <td>{account.description}</td>
                                        <td>{account.issuingBank}</td>
                                        <td>{account.initialBalance}</td>
                                        <td>{account.currentBalance}</td>
                                        <td>
                                            <ButtonGroup>
                                                <Button size="sm" variant="outline-primary"><FontAwesomeIcon icon={faEdit} /></Button>
                                                <Button size="sm" variant="outline-danger"><FontAwesomeIcon icon={faTrash} /></Button>
                                            </ButtonGroup>
                                        </td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }
}