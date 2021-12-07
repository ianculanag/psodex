import React from 'react';
import './App.css';

import { Container, Row, Col } from 'react-bootstrap';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

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
            <Routes>
              <Route path="/" element={<Welcome/>}/>
            </Routes>
            <Routes>
              <Route path="/add" element={<Account/>}/>
            </Routes>
            <Routes>
              <Route path="/list" element={<AccountList/>}/>
            </Routes>
          </Col>
        </Row>
      </Container>
      <Footer />
    </Router>
  );
}

export default App;
