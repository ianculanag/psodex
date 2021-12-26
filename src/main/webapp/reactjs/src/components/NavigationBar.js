import React from 'react';

import { Navbar, Container, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom';

export default function NavigationBar() {
    return (
        <Navbar bg="dark" variant="dark">
            <Container>
                <Link to={""} className="navbar-brand">
                    <img src="https://cdn.iconscout.com/icon/free/png-256/wallet-2130848-1794979.png" width="25" height="25" alt="ePon Logo" />ePon
                </Link>
                <Nav className="me-auto">
                    <Link to={"/add-account"} className="nav-link">Add Account</Link>
                    <Link to={"/account-list"} className="nav-link">Account List</Link>
                    <Link to={"/record-transaction"} className="nav-link">Record Transaction</Link>
                    <Link to={"/transaction-list"} className="nav-link">Transaction List</Link>
                </Nav>
            </Container>
        </Navbar>
    );
}
