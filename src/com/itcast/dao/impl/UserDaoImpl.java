package com.itcast.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;

/**
 * 为HibernateDaoSupprot 为dao注入sessionFacoty
 * @author nice
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	
	private HibernateTemplate ht;
	/* (non-Javadoc)
	 * @see com.itcast.dao.UserDao#getByUserCode(java.lang.String)
	 */
	@Override
	public User getByUserCode(final String userCode) {
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			/** (non-Javadoc)
			 * @see org.springframework.orm.hibernate3.HibernateCallback#doInHibernate(org.hibernate.Session)
			 */
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql = "from User where user_code = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, userCode);
				User user = (User)query.uniqueResult();
				return user;
			}
		});
/*		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", userCode));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		
		if(list !=null && list.size()>0) {
			return list.get(0);
		}
		else {
			return null;
		}*/
		
	}
	
	
}
