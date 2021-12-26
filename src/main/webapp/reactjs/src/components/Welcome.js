import React from 'react';

export default function Welcome(props) {
    return (
        <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold">{props.heading}</h1>
                <p class="col-md-12 fs-4">
                    <blockquote className="blockquote mb-0">
                        <p>
                            {props.desc}
                        </p>
                        <footer className="blockquote-footer">
                            {props.footer}
                        </footer>
                    </blockquote>
                </p>
            </div>
        </div>
    )
}
