import React from 'react';
import './App.css';

import { Container, Row, Col } from 'react-bootstrap';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

import NavigationBar from './components/NavigationBar';
import Welcome from './components/Welcome';
import Footer from './components/Footer';
import Account from './components/Account';
import AccountList from './components/AccountList';

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
              <Route path="/add" exact component={Account} />
              <Route path="/edit/:id" exact component={Account} />
              <Route path="/list" exact component={AccountList} />
            </Switch>
          </Col>
        </Row>
      </Container>
      <Footer />
    </Router>
  );
}

export default App;
