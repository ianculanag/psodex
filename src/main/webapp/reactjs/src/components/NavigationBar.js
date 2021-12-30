import React, {Component} from 'react';
import {connect} from 'react-redux';

import { Navbar, Nav, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {faUserPlus, faSignInAlt, faSignOutAlt} from '@fortawesome/free-solid-svg-icons';

import {logoutUser} from '../services/index';

class NavigationBar extends Component {
    logout = () => {
        this.props.logoutUser();
    }

    render() {
        const guestLinks = (
            <>
                <Nav className="navbar-right">
                    <Link to={"register"} className="nav-link"><FontAwesomeIcon icon={faUserPlus}/> Register</Link>
                    <Link to={"login"} className="nav-link"><FontAwesomeIcon icon={faSignInAlt}/> Login</Link>
                </Nav>
            </>
        );

        const userLinks = (
            <>
                <Nav className="me-auto">
                    <Link to={"add-account"} className="nav-link">Add Account</Link>
                    <Link to={"account-list"} className="nav-link">Account List</Link>
                    <Link to={"record-transaction"} className="nav-link">Record Transaction</Link>
                    <Link to={"transaction-list"} className="nav-link">Transaction List</Link>
                </Nav>
                <Nav className="navbar-right">
                    <Link to={"logout"} className="nav-link" onClick={this.logout}><FontAwesomeIcon icon={faSignOutAlt}/> Logout</Link>
                </Nav>
            </>
        );

        return (
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Link to={""} className="navbar-brand">
                        <img src="https://cdn.iconscout.com/icon/free/png-256/wallet-2130848-1794979.png" width="25" height="25" alt="ePon Logo" />ePon
                    </Link>
                    {this.props.auth.isLoggedIn ? userLinks : guestLinks}
                </Container>
            </Navbar>
        );
    }
}

const mapStateToProps = state => {
    return {
        auth: state.auth
    };
};

const mapDispatchToProps = dispatch => {
    return {
        logoutUser: () => dispatch(logoutUser())
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(NavigationBar);
