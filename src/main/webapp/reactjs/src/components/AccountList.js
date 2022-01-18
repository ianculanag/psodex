import React, { Component } from 'react';

import {connect} from 'react-redux';
import {deleteAccount} from '../services/index';

import { Card, Table, ButtonGroup, Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faList, faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import { Link } from 'react-router-dom';

import MyToast from './MyToast';
import axios from 'axios';

class AccountList extends Component {

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

    deleteAccount = (accountId) => {
        axios.delete("http://localhost:3030/accounts/" + accountId)
            .then(response => {
                if (response.data != null) {
                    this.setState({ "show": true });
                    setTimeout(() => this.setState({ "show": false }), 3000);
                    this.setState({
                        accounts: this.state.accounts.filter(account => account.accountId !== accountId)
                    });
                } else {
                    this.setState({ "show": false });
                }
            });
    };

    render() {
        return (
            <div>
                <div style={{ "display": this.state.show ? "block" : "none" }}>
                    <MyToast show = {this.state.show} message = {"Account Deleted Successfully"} type = {"danger" }/>
                </div>
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
                                    <th>Balance</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.accounts.length === 0 ?
                                    <tr align="center">
                                        <td colSpan="7">No Accounts Available.</td>
                                    </tr>
                                    :
                                    this.state.accounts.map((account) => (
                                        <tr key={account.accountId}>
                                            <td>{account.accountId}</td>
                                            <td>{account.accountName}</td>
                                            <td>{account.accountNumber}</td>
                                            <td>{account.description}</td>
                                            <td>{account.issuingBank}</td>
                                            <td>{account.balance}</td>
                                            <td>
                                                <ButtonGroup>
                                                    <Link to={"/edit-account/" + account.accountId} className="btn btn-sm btn-outline-primary"><FontAwesomeIcon icon={faEdit} /></Link>{' '}
                                                    <Button size="sm" variant="outline-danger"
                                                        onClick={this.deleteAccount.bind(this, account.accountId)}><FontAwesomeIcon icon={faTrash} /></Button>
                                                </ButtonGroup>
                                            </td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </Table>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        accountObject: state.account
    };
};

const mapDispatchToProps = dispatch => {
    return {
        deleteAccount: (accountId) => dispatch(deleteAccount(accountId))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(AccountList);