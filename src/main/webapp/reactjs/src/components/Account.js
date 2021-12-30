import React, { Component } from 'react';

import {connect} from 'react-redux';
import {saveAccount, fetchAccount, updateAccount} from '../services/index';

import { Card, Form, Button, Row, Col } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlusSquare, faSave, faUndo, faList, faEdit } from '@fortawesome/free-solid-svg-icons';
import MyToast from './MyToast';

class Account extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.accountChange = this.accountChange.bind(this);
        this.submitAccount = this.submitAccount.bind(this);
    };

    initialState = {
        accountId: '', accountName: '', accountNumber: '', description: '', issuingBank: '', balance: ''
    };

    componentDidMount() {
        const accountId = +this.props.match.params.id;
        if (accountId) {
            this.findAccountById(accountId);
        }
    };

    findAccountById = (accountId) => {
        this.props.fetchAccount(accountId);
        setTimeout(() => {
            let account = this.props.accountObject.account;
            if (account != null) {
                this.setState({
                    accountId: account.accountId,
                    accountName: account.accountName,
                    accountNumber: account.accountNumber,
                    description: account.description,
                    issuingBank: account.issuingBank,
                    balance: account.balanceRaw
                });
            }
        });
    }

    resetAccount = () => {
        this.setState(() => this.initialState);
    };

    submitAccount = event => {
        event.preventDefault();

        const account = {
            accountName: this.state.accountName,
            accountNumber: this.state.accountNumber,
            description: this.state.description,
            issuingBank: this.state.issuingBank,
            balance: this.state.balance
        }

        this.props.saveAccount(account);
        setTimeout(() => {
            if (this.props.savedAccountObject.account != null) {
                this.setState({"show": true, "method":"post"});
                setTimeout(() => this.setState({"show": false}), 3000);
            } else {
                this.setState({"show": false});
            }
        }, 2000);

        this.setState(this.initialState);
    }

    updateAccount = event => {
        event.preventDefault();

        const account = {
            accountName: this.state.accountName,
            accountNumber: this.state.accountNumber,
            description: this.state.description,
            issuingBank: this.state.issuingBank,
            balance: this.state.balance
        }

        this.props.updateAccount(this.state.accountId, account);
        setTimeout(() => {
            if (this.props.updatedAccountObject.account != null) {
                this.setState({"show": true, "method":"put"});
                setTimeout(() => this.setState({"show": false}), 3000);
            } else {
                this.setState({"show": false});
            }
        }, 2000);

        this.setState(this.initialState);
    };

    accountChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    accountList = () => {
        return this.props.history.push("/account-list");
    };

    render() {
        const { accountName, accountNumber, description, issuingBank, balance } = this.state;

        return (
            <div>
                <div style={{ "display": this.state.show ? "block" : "none" }}>
                    <MyToast show={this.state.show} message={this.state.method === "put" ? "Account Updated Succesfully" : "Account Saved Successfully"} type={"success"} />
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header><FontAwesomeIcon icon={this.state.accountId ? faEdit : faPlusSquare} /> {this.state.accountId ? "Update Account" : "Add New Account"}</Card.Header>
                    <Form onReset={this.resetAccount} onSubmit={this.state.accountId ? this.updateAccount : this.submitAccount} id="accountFormId">
                        <Card.Body>
                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridAccountName">
                                    <Form.Label>Account Name</Form.Label>
                                    <Form.Control required autoComplete="off"
                                        type="text" name="accountName"
                                        value={accountName} onChange={this.accountChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter the Account Name" />
                                </Form.Group>

                                <Form.Group as={Col} controlId="formGridAccountNumber">
                                    <Form.Label>Account Number</Form.Label>
                                    <Form.Control autoComplete="off"
                                        type="text" name="accountNumber"
                                        value={accountNumber} onChange={this.accountChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter the Account Number" />
                                </Form.Group>
                            </Row>

                            <Form.Group className="mb-3" controlId="formGridDescription">
                                <Form.Label>Description</Form.Label>
                                <Form.Control autoComplete="off"
                                    type="text" name="description"
                                    value={description} onChange={this.accountChange}
                                    className={"bg-dark text-white"}
                                    placeholder="Provide a short description of the account" />
                            </Form.Group>

                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridIssuingBank">
                                    <Form.Label>Issuing Bank</Form.Label>
                                    <Form.Control autoComplete="off"
                                        type="text" name="issuingBank"
                                        value={issuingBank} onChange={this.accountChange}
                                        className={"bg-dark text-white"}
                                        placeholder="Enter the Issuing Bank" />
                                </Form.Group>

                                <Form.Group as={Col} controlId="formGridBalance">
                                    <Form.Label>{this.state.accountId ? "Current" : "Initial"} Balance</Form.Label>
                                    <Form.Control required autoComplete="off"
                                        type="text" name="balance"
                                        value={balance} onChange={this.accountChange}
                                        className={"bg-dark text-white"}
                                        placeholder="000.00" />
                                </Form.Group>
                            </Row>
                        </Card.Body>
                        <Card.Footer style={{ "textAlign": "right" }}>
                            <Button size="sm" variant="primary" type="submit">
                                <FontAwesomeIcon icon={faSave} /> {this.state.accountId ? "Update" : "Save"}
                            </Button>
                            {' '}
                            <Button size="sm" variant="info" type="reset">
                                <FontAwesomeIcon icon={faUndo} /> Reset
                            </Button>
                            {' '}
                            <Button size="sm" variant="info" type="button" onClick={this.accountList.bind()}>
                                <FontAwesomeIcon icon={faList} /> Account List
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        );
    }
};

const mapStateToProps = state => {
    return {
        savedAccountObject: state.account,
        accountObject: state.account,
        updatedAccountObject: state.account
    };
};

const mapDispatchToProps = dispatch => {
    return {
        saveAccount: (account) => dispatch(saveAccount(account)),
        fetchAccount: (accountId) => dispatch(fetchAccount(accountId)),
        updateAccount: (accountId, account) => dispatch(updateAccount(accountId, account))
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(Account);