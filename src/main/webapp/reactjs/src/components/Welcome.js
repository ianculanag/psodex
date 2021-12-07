import React from 'react';

class Welcome extends React.Component {
    render() {
        return (
            <div class="p-5 mb-4 bg-light rounded-3">
                <div class="container-fluid py-5">
                    <h1 class="display-5 fw-bold">Welcome to ePon!</h1>
                    <p class="col-md-12 fs-4">
                        <blockquote className="blockquote mb-0">
                            <p>
                                “It's not now much money you make, but how much money you keep, how hard it works for you, and how many generations you keep it for.”
                            </p>
                            <footer className="blockquote-footer">
                                Robert Kiyosaki
                            </footer>
                        </blockquote>
                    </p>
                </div>
            </div>
        )
    }
}

export default Welcome;