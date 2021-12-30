import React, {Component} from 'react';
import {connect} from 'react-redux';
import {fetchTransactions} from '../services/transaction/transactionActions';
import { Card, Table, InputGroup, FormControl, Button, Alert} from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faList, faStepBackward, faFastBackward, faStepForward, faFastForward } from '@fortawesome/free-solid-svg-icons';

class TransactionList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            transactions: [],
            currentPage : 1,
            usersPerPage: 5
        };
    };

    componentDidMount() {
        this.props.fetchTransactions();
    }

    changePage = event => {
        this.setState({
            [event.target.name]: parseInt(event.target.value)
        });
    };

    firstPage = () => {
        if (this.state.currentPage > 1) {
            this.setState({
                currentPage: 1
            });
        }
    };

    prevPage = () => {
        if (this.state.currentPage > 1) {
            this.setState({
                currentPage: this.state.currentPage - 1
            });
        }
        
    };

    lastPage = () => {
        let transactionsLength = this.props.transactionData.transactions.length;
        if (this.state.currentPage < Math.ceil(transactionsLength / this.state.usersPerPage)) {
            this.setState({
                currentPage: Math.ceil(transactionsLength / this.state.usersPerPage)
            });
        }
    };

    nextPage = () => {
        if (this.state.currentPage < Math.ceil(this.props.transactionData.transactions.length / this.state.usersPerPage)) {
            this.setState({
                currentPage: this.state.currentPage + 1
            });
        }
    };

    render() {
        const {currentPage, usersPerPage } = this.state;
        const lastIndex = currentPage * usersPerPage;
        const firstIndex = lastIndex - usersPerPage;

        const transactionData = this.props.transactionData;
        const transactions = transactionData.transactions;

        const sortedTransactions = transactions.sort((a, b) => Date.parse(a.transactionDate) - Date.parse(b.transactionDate));
        const currentTransactions = sortedTransactions.slice(firstIndex, lastIndex);
        const totalPages = Math.ceil(transactions.length / usersPerPage);

        const pageNumCss = {
            width: "45px",
            border: "1px solid #17A2B8",
            color: "#17A2B8",
            textAlign: "center",
            fontWeight: "bold"
        };

        return (
            <div>
                {transactionData.error ?
                    <Alert variant="danger">
                        {transactionData.error}
                    </Alert> : 
                    <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header><FontAwesomeIcon icon={faList} /> Transaction List</Card.Header>
                    <Card.Body>
                        <Table bordered hover striped variant="dark">
                            <thead>
                                <tr>
                                    <th>Details</th>
                                    <th>Amount</th>
                                    <th>Date</th>
                                    <th>Type</th>
                                    <th>Inbound Account</th>
                                    <th>Outbound Account</th>
                                </tr>
                            </thead>
                            <tbody>
                            {currentTransactions.length === 0 ?
                                    <tr align="center">
                                        <td colSpan="7">No Accounts Available.</td>
                                    </tr>
                                    :
                                    currentTransactions.map((transaction) => (
                                        <tr key={transaction.transactionId}>
                                            <td>{transaction.details}</td>
                                            <td>{transaction.transactionAmount}</td>
                                            <td>{transaction.transactionDate}</td>
                                            <td>{transaction.transactionType}</td>
                                            <td>{transaction.inboundAccountName}</td>
                                            <td>{transaction.outboundAccountName}</td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </Table>
                    </Card.Body>
                    <Card.Footer>
                        <div style={{"float":"left"}}>
                            Showing Page {currentPage} of {totalPages}
                        </div>
                        <div style={{"float":"right"}}>
                            <InputGroup size="sm">
                                <InputGroup.Prepend>
                                    <Button type="button" variant="outline-info" disabled={currentPage === 1 ? true : false}
                                        onClick={this.firstPage}>
                                        <FontAwesomeIcon icon={faFastBackward} /> First
                                    </Button>
                                    <Button type="button" variant="outline-info" disabled={currentPage === 1 ? true : false}
                                        onClick={this.prevPage}>
                                        <FontAwesomeIcon icon={faStepBackward} /> Prev
                                    </Button>
                                </InputGroup.Prepend>
                                <FormControl disabled="true" style={pageNumCss} className={"bg-dark"} name="currentPage" value={currentPage}
                                        onChange={this.changePage}
                                />
                                <InputGroup.Append>
                                    <Button type="button" variant="outline-info" disabled={currentPage === totalPages ? true : false}
                                        onClick={this.nextPage}>
                                        <FontAwesomeIcon icon={faStepForward} /> Next
                                    </Button>
                                    <Button type="button" variant="outline-info" disabled={currentPage === totalPages ? true : false}
                                        onClick={this.lastPage}>
                                        <FontAwesomeIcon icon={faFastForward} /> Last
                                    </Button>
                                </InputGroup.Append>
                            </InputGroup>
                        </div>
                    </Card.Footer>
                </Card>
                }
            </div>
        )
    }
}

const mapStateToProps = state => {
    return {
        transactionData: state.transaction
    }
};

const mapDispatchToProps = dispatch => {
    return {
        fetchTransactions: () => dispatch(fetchTransactions())
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(TransactionList);