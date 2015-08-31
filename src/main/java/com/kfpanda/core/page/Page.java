package com.kfpanda.core.page;

import java.io.Serializable;


public class Page implements Serializable{
	 /** 
	 *
	 */
	private static final long	serialVersionUID	= -8837789564979019410L;
	// 1.每页显示数量(everyPage)  
    private int pageSize=10;  
    // 2.总记录数(totalCount)  
    private int totalCount;  
    // 3.总页数(totalPage)  
    private int totalPage;  
    // 4.当前页(currentPage)  
    private int curPage=1;  
    // 5.起始点(beginIndex)  
    private int beginIndex;
    // 6.是否有上一页(hasPrePage)  
    private boolean hasPrePage;  
    // 7.是否有下一页(hasNextPage)  
    private boolean hasNextPage; 
    // 8.是否分页
    private boolean pagination=false;
    
  

    public void init(int curpage, int pagesize,int totalCount){
    	this.pageSize = pagesize;

		this.totalCount = totalCount;

		if ((totalCount % pagesize) == 0) {
			totalPage = totalCount / pagesize;
		} else {
			totalPage = totalCount / pagesize + 1;
		}
		
		if ((curpage - 1) > 0) {
			hasPrePage = true;
		} else {
			hasPrePage = false;
		}

		if (curpage >= totalPage) {
			hasNextPage = false;
		} else {
			hasNextPage = true;
		}

		beginIndex = (curpage-1) * pagesize;
    }
	//构造函数，默认  
    public Page(){}  
      
    //构造方法，对所有属性进行设置  
      
      
  
    public int getTotalCount() {  
        return totalCount;  
    }  
  
    
	public Page(int pagesize, int totalCount, int totalPage, int curpage, int beginIndex, boolean hasPrePage,
			boolean hasNextPage) {
		super();
		this.pageSize = pagesize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.curPage = curpage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}
	public int getPageSize() {
		return pageSize;
	}

	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	public int getCurPage() {
		return curPage;
	}

	
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setTotalCount(int totalCount) {  
        this.totalCount = totalCount;  
    }  
  
    public int getTotalPage() {  
        return totalPage;  
    }  
  
    public void setTotalPage(int totalPage) {  
        this.totalPage = totalPage;  
    }  
  
    public int getBeginIndex() {  
        return beginIndex;  
    }  
  
    public void setBeginIndex(int beginIndex) {  
        this.beginIndex = beginIndex;  
    }  
  
    public boolean isHasPrePage() {  
        return hasPrePage;  
    }  
  
    public void setHasPrePage(boolean hasPrePage) {  
        this.hasPrePage = hasPrePage;  
    }  
  
    public boolean isHasNextPage() {  
        return hasNextPage;  
    }  
  
    public void setHasNextPage(boolean hasNextPage) {  
        this.hasNextPage = hasNextPage;  
    }
	
	public boolean isPagination() {
		return pagination;
	}
	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}  
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + beginIndex;
		result = prime * result + curPage;
		result = prime * result + (hasNextPage ? 1231 : 1237);
		result = prime * result + (hasPrePage ? 1231 : 1237);
		result = prime * result + pageSize;
		result = prime * result + (pagination ? 1231 : 1237);
		result = prime * result + totalCount;
		result = prime * result + totalPage;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (beginIndex != other.beginIndex)
			return false;
		if (curPage != other.curPage)
			return false;
		if (hasNextPage != other.hasNextPage)
			return false;
		if (hasPrePage != other.hasPrePage)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (pagination != other.pagination)
			return false;
		if (totalCount != other.totalCount)
			return false;
		if (totalPage != other.totalPage)
			return false;
		return true;
	}
}
