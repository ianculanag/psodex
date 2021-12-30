import {combineReducers} from 'redux';
import transactionReducer from './transaction/transactionReducer';
import accountReducer from './account/accountReducer';
import authReducer from './user/auth/authReducer';

const rootReducer = combineReducers({
    transaction: transactionReducer,
    account: accountReducer,
    auth: authReducer
});

export default rootReducer;