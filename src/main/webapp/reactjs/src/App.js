import React from 'react';
import './App.css';

import { Container, Row, Col } from 'react-bootstrap';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import Welcome from './components/Welcome';
import Footer from './components/Footer';
import Account from './components/Account';
import AccountList from './components/AccountList';
import RecordTransaction from './components/RecordTransaction';
import TransactionList from './components/TransactionList';

function App() {
  const marginTop = {
    marginTop: "20px"
  }

  return (
    <Router>
      <NavigationBar />
      <Container>
        <Row>
          <Col lg={12} style={marginTop}>
            <Switch>
              <Route path="/" exact component={Welcome} />
              <Route path="/add-account" exact component={Account} />
              <Route path="/edit-account/:id" exact component={Account} />
              <Route path="/account-list" exact component={AccountList} />
              <Route path="/record-transaction" exact component={RecordTransaction} />
              <Route path="/transaction-list" exact component={TransactionList} />
            </Switch>
          </Col>
        </Row>
      </Container>
      <Footer />
    </Router>
  );
}

export default App;
