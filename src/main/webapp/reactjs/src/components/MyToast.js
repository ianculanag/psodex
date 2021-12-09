import React, { Component } from 'react';
import {Toast} from 'react-bootstrap';

export default class Account extends Component {
    render() {
        const toastCss = {
            position: 'fixed',
            width: '200px',
            top: '10px',
            right: '10px',
            zIndex: '1',
            boxShadow: '0 4px 8px 0 grba(0, 0, 0, 0.2), 0 6px 20px 0 rgba (0, 0, 0, 0.19)'
        }

        const none = {};

        return (
            <div style={this.props.children.message ? toastCss : none}>
                <Toast className={"border border-success bg-success text-white"} show={this.props.children.message}>
                    <Toast.Header className={"bg-success text-white"} closeButton={false}>
                        <strong className="mr-auto">Success</strong>
                    </Toast.Header>
                    <Toast.Body>
                        {this.props.children.message}
                    </Toast.Body>
                </Toast>
            </div>
        );
    }
}