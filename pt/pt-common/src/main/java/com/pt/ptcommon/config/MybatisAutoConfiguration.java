/*
 *
 *  *  Copyright (c) 2019-2020, 冷冷 (wangiegie@gmail.com).
 *  *  <p>
 *  *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *  <p>
 *  * https://www.gnu.org/licenses/lgpl.html
 *  *  <p>
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.pt.ptcommon.config;

import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.pt.ptcommon.constant.CommonConstants;
import com.pt.ptcommon.util.SecurityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author wl
 * @date 2020/6/2
 * mybatis plus 分页配置
 */
@Configuration(proxyBeanMethods = false)
public class MybatisAutoConfiguration {
	/**
	 * 分页插件
	 *
	 *
	 * @return PaginationInterceptor
	 */

	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
		dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>(2) {{
			CommonConstants.DYNAMIC_TABLES.forEach(table ->{
				put("dynamic_"+table,(metaObject, sql, tableName) ->
					tableName.replace("dynamic",SecurityUtils.getUser().getClientId())
				);
			});
		}});
		paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
		return paginationInterceptor;
	}
}
